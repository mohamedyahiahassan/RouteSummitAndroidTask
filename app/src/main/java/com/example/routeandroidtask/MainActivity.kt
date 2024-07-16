package com.example.routeandroidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults.windowInsets
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.routeandroidtask.ui.theme.RouteAndroidTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ProductsViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RouteAndroidTaskTheme {
                
                Scaffold(

                    modifier = Modifier.padding(
                        top = windowInsets.asPaddingValues().calculateTopPadding(),
                        bottom = windowInsets.asPaddingValues().calculateBottomPadding()
                    ),
                    topBar = {
                        AppTopAppBar(){

                        }
                    }
                ) {

                    Column(
                        modifier = Modifier
                            .padding(
                                top = it.calculateTopPadding() + 17.dp,
                                start = 17.dp,
                                end = 17.dp,
                                bottom = it.calculateBottomPadding()
                            )
                            .fillMaxSize(1f)
                    )
                    {

                        ProductListContent(viewModel)
                    }



               }

            }
        }
    }


}
