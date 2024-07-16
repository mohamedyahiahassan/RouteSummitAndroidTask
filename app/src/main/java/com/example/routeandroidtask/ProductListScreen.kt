package com.example.routeandroidtask

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.routeandroidtask.ui.theme.blueTextColor
import com.example.routeandroidtask.ui.theme.greyBlueBorderSideMenu


@Composable
fun ProductListContent(viewModel: ProductsViewModel = viewModel()){


    LaunchedEffect(key1 = Unit) {

        viewModel.getProductList()

    }

    LoadingDialog(isLoading = viewModel.isLoading)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f),
        horizontalArrangement = Arrangement.spacedBy(17.dp)
    ) {



        items(viewModel.listOfProducts) {productItem->

            Box(
                modifier = Modifier
                    .padding(bottom = 17.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, greyBlueBorderSideMenu, RoundedCornerShape(10.dp))
                    .background(Color.Transparent, RoundedCornerShape(10.dp))
                    .clickable {

                    }
            ) {

            Column(
                ) {

              //  Spacer(modifier = Modifier.height(10.dp))
                    AsyncImage(
                        model = productItem.thumbnail,
                        contentDescription = "product thumbnail",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(130.dp)
                    )


                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
                    ) {

                        Text(
                            text = productItem.title?:"",
                            fontSize = 14.sp,
                            color = blueTextColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = productItem.description?:"",
                            fontSize = 14.sp,
                            color = blueTextColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "EGP ${productItem.price}",
                            fontSize = 14.sp,
                            color = blueTextColor,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Review (${productItem.rating})",
                                fontSize = 14.sp,
                                color = blueTextColor,
                            )

                            Image(
                                painter = painterResource(id = R.drawable.star_rating),
                                contentDescription = "rating star",
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .size(15.dp)
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Image(
                                painter = painterResource(id = R.drawable.icon_plus_circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(28.dp)
                                    .clickable {

                                    })
                        }


                    }


                }



                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .padding(end = 6.dp, bottom = 10.dp, top = 6.dp)
                        .fillMaxSize(1f)
                ) {

                    val favoriteClicked = remember {
                        mutableStateOf(false)
                    }

                    if (favoriteClicked.value == false){

                        Image(
                            painter = painterResource(id = R.drawable.favourite_ic_unselected),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)
                                .clickable {

                                    favoriteClicked.value = true

                                })
                    } else{

                        Image(
                            painter = painterResource(id = R.drawable.favorite_selected_ic),
                            contentDescription = "",
                            modifier = Modifier
                                .size(28.dp)
                                .clickable {

                                    favoriteClicked.value = false

                                })
                    }








                }
            }
        }
    }
}