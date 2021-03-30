package com.tongfu.mytestapp.video

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.media.session.PlaybackState
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.*
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.tongfu.mytestapp.R
import java.util.concurrent.Executors


class ExoVideoPlayActivity : AppCompatActivity() {
    @BindView(R.id.surfaceView)
    lateinit var surfaceView: SurfaceView
    @BindView(R.id.seekBar)
    lateinit var seekBar:SeekBar
    @BindView(R.id.tv_play_time)
    lateinit var alreadyPlayerTime:TextView
    @BindView(R.id.tv_total_time)
    lateinit var totalPlayerTime:TextView
    @BindView(R.id.btn_play)
    lateinit var btnPlay: Button
    @BindView(R.id.btn_fullscreen)
    lateinit var btnFullscreen:Button

    lateinit var mediaPlayer: SimpleExoPlayer

    private val executors by lazy{ Executors.newSingleThreadExecutor()}


    private var playFlag = false //播放状态
    private var screenFlag = false;//全屏标记


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ijk_video_play)
        ButterKnife.bind(this)

        val bandwidthMeter = DefaultBandwidthMeter()
        val videoTrackSelectionFactor: TrackSelection.Factory = AdaptiveTrackSelection.Factory()
        val trackSelector: TrackSelector = DefaultTrackSelector(videoTrackSelectionFactor)
        val loadControl: LoadControl = DefaultLoadControl()
        val renderFactory = DefaultRenderersFactory(this)
        mediaPlayer = ExoPlayerFactory.newSimpleInstance(this, renderFactory , trackSelector, loadControl);

        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(this, System.getProperty("http.agent"), bandwidthMeter)

        val extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory()
        val videoSource: MediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
                .setExtractorsFactory(extractorsFactory)
                .createMediaSource(Uri.parse(intent.getStringExtra("url")))
        mediaPlayer.prepare(videoSource)
        mediaPlayer.addListener(object :Player.EventListener{
            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
            }

            override fun onSeekProcessed() {
            }

            override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
//                super.onTracksChanged(trackGroups, trackSelections)
                Log.i(this@ExoVideoPlayActivity.javaClass.name , "onTracksChanged")
            }

            override fun onPlayerError(error: ExoPlaybackException?) {
                Log.i(this@ExoVideoPlayActivity.javaClass.name , "onPlayerError: ${error?.message?:"Unknown Error"}")

            }

            override fun onLoadingChanged(isLoading: Boolean) {
//                super.onLoadingChanged(isLoading)
                seekBar.secondaryProgress = (mediaPlayer.bufferedPosition / 1000).toInt()
            }

            override fun onPositionDiscontinuity(reason: Int) {
//                super.onPositionDiscontinuity(reason)
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
//                super.onRepeatModeChanged(repeatMode)
            }

            override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
//                super.onShuffleModeEnabledChanged(shuffleModeEnabled)
            }

            override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
                Log.i(this@ExoVideoPlayActivity.javaClass.name , "onTimelineChanged: timeline: $timeline")
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
//                super.onPlayerStateChanged(playWhenReady, playbackState)
                when (playbackState) {
                    PlaybackState.STATE_PLAYING -> {
                        //设置总时长
                        totalPlayerTime.text = (mediaPlayer.duration/1000).toString();

                        seekBar.max = (mediaPlayer.getDuration() / 1000).toInt()
                        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}
                            override fun onStartTrackingTouch(seekBar: SeekBar) {}
                            override fun onStopTrackingTouch(seekBar: SeekBar) {
                                //是暂停的开始播放
                                if (!mediaPlayer.getPlayWhenReady()) {
                                    continuePlay() //继续播放
                                }
                                mediaPlayer.seekTo(seekBar.progress.toLong() * 1000)
                            }
                        })

                        //播放按钮

                        //播放按钮
                        btnPlay.setOnClickListener {
                            if (mediaPlayer.getPlayWhenReady()) {
                                pausePlay() //暂停播放
                            } else {
                                continuePlay() //继续播放
                            }
                        }
                        //全屏切换
                        btnFullscreen.setOnClickListener(View.OnClickListener {
                            if (screenFlag) //是全屏
                            {
                                screenFlag = false //设置为半屏
                                supportActionBar?.show()
                                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                                window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
                                window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                            } else {
                                screenFlag = true //设置为全屏
                                supportActionBar?.hide()
                                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                                window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                            }
                        })


                        println("播放状态: 准备 playing")
                    }
                    PlaybackState.STATE_BUFFERING -> println("播放状态: 缓存完成 playing")
                    PlaybackState.STATE_CONNECTING -> println("播放状态: 连接 CONNECTING")
                    PlaybackState.STATE_ERROR -> println("播放状态: 错误 STATE_ERROR")
                    PlaybackState.STATE_FAST_FORWARDING -> {
                        println("播放状态: 快速传递")
                        pausePlay() //暂停播放
                    }
                    PlaybackState.STATE_NONE -> println("播放状态: 无 STATE_NONE")
                    PlaybackState.STATE_PAUSED -> println("播放状态: 暂停 PAUSED")
                    PlaybackState.STATE_REWINDING -> println("播放状态: 倒回 REWINDING")
                    PlaybackState.STATE_SKIPPING_TO_NEXT -> println("播放状态: 跳到下一个")
                    PlaybackState.STATE_SKIPPING_TO_PREVIOUS -> println("播放状态: 跳到上一个")
                    PlaybackState.STATE_SKIPPING_TO_QUEUE_ITEM -> println("播放状态: 跳到指定的Item")
                    PlaybackState.STATE_STOPPED -> println("播放状态: 停止的 STATE_STOPPED")
                }
            }
        })
        mediaPlayer.setVideoSurfaceView(surfaceView)
//        surfaceView.holder.addCallback(object : SurfaceHolder.Callback {
//            override fun surfaceCreated(holder: SurfaceHolder) {
//                mediaPlayer.setVideoSurfaceHolder(holder)
//            }
//
//            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
//            override fun surfaceDestroyed(holder: SurfaceHolder) {}
//        })
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        }
        executors.shutdown()
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onDestroy()
    }

    //暂停播放
    private fun pausePlay() {
        mediaPlayer.playWhenReady = false
//        startPlay.setBackgroundColor(Color.WHITE)
        btnPlay.text = "Play"
        playFlag = false
    }

    //继续播放
    private fun continuePlay() {
        mediaPlayer.playWhenReady = true
        btnPlay.text = "Pause"
//        startPlay.setBackgroundColor(Color.RED)
        //开始读取进度
        playFlag = true
        executors.execute(runnable)
    }

    //开启线程读取进度
    private val runnable = Runnable {
        while (playFlag) {
            val progress =  (mediaPlayer.currentPosition / 1000).toInt()
            runOnUiThread {
                seekBar.progress = progress
                alreadyPlayerTime.text = progress.toString()
            }
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}