package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.filmfinder.R
import com.thiagoperea.filmfinder.data.model.MovieCategories
import com.thiagoperea.filmfinder.data.model.MovieListItemResponse
import com.thiagoperea.filmfinder.ui.screens.movielist.views.MovieListItemView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreenContent(
    movieList: List<MovieListItemResponse>,
    categoryList: List<MovieCategories> = listOf(),
    selectedCategory: MovieCategories = MovieCategories.LATEST,
    onItemClicked: (MovieListItemResponse) -> Unit = {},
    onCategorySelected: (MovieCategories) -> Unit = {}
) {

    val selectorExpanded = remember { mutableStateOf(false) }

    val selectedCategoryText = stringResource(selectedCategory.stringRes)
    val selectedText = remember { mutableStateOf(selectedCategoryText) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ExposedDropdownMenuBox(
            expanded = selectorExpanded.value,
            onExpandedChange = {
                selectorExpanded.value = it
            }
        ) {
            OutlinedTextField(
                value = selectedText.value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = selectorExpanded.value) },
                modifier = Modifier.menuAnchor(),
                label = {
                    Text(stringResource(R.string.category))
                }
            )

            ExposedDropdownMenu(
                expanded = selectorExpanded.value,
                onDismissRequest = { selectorExpanded.value = false }
            ) {
                categoryList.forEach { item ->

                    val categoryText = stringResource(item.stringRes)

                    DropdownMenuItem(
                        text = { Text(text = categoryText) },
                        onClick = {
                            selectedText.value = categoryText
                            selectorExpanded.value = false
                            onCategorySelected(item)
                        }
                    )
                }
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(80.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(movieList) { movie ->
                    MovieListItemView(
                        data = movie,
                        onItemClicked = {
                            onItemClicked(movie)
                        }
                    )
                }
            }
        )
    }
}
