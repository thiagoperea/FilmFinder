package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.filmfinder.data.model.MovieCategories
import com.thiagoperea.filmfinder.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieListViewModel(val repository: MovieRepository) : ViewModel() {

    val screenState = mutableStateOf<MovieListState>(MovieListState.Loading)
    val screenEvent = mutableStateOf<MovieListEvent>(MovieListEvent.Idle)

    lateinit var categoryList: List<MovieCategories>
    lateinit var selectedCategory: MovieCategories
    var currentPage = 0
    var pageCount = 0

    fun loadInitialData() {
        viewModelScope.launch {

            try {
                categoryList = repository.getCategories()
                selectedCategory = categoryList.first()

                val movieList = repository.getAllMovies(
                    categoryUrl = selectedCategory.urlQuery
                )

                currentPage = movieList.page
                pageCount = movieList.totalPages

                screenState.value = MovieListState.Success(
                    categories = categoryList,
                    categorySelected = selectedCategory,
                    movieList = movieList.results ?: emptyList()
                )
            } catch (error: Exception) {
                screenState.value = MovieListState.Error(error.message.orEmpty())
            }
        }
    }

    fun loadMoviesFromCategory(category: MovieCategories) {

        viewModelScope.launch {

            try {
                screenState.value = MovieListState.Loading

                selectedCategory = category

                val movieList = repository.getAllMovies(
                    categoryUrl = selectedCategory.urlQuery
                )

                currentPage = movieList.page
                pageCount = movieList.totalPages

                screenState.value = MovieListState.Success(
                    categories = categoryList,
                    categorySelected = selectedCategory,
                    movieList = movieList.results ?: emptyList()
                )
            } catch (error: Exception) {
                screenState.value = MovieListState.Error(error.message.orEmpty())
            }
        }
    }
}
