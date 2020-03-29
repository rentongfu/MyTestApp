package com.tongfu.mytestapp.architecture.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class PagingViewModel extends ViewModel {
    FakePersonDao personDao = new FakePersonDao();
    LiveData<PagedList<Person>> personList = new LivePagedListBuilder<Integer , Person >(personDao.getPersons() , 15 ).build();
}
