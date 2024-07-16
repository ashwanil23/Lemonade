package com.example.lemonade

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold (
        modifier = Modifier,
        topBar ={
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Lemonade",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp)
                }
            )
        }
    ){
        when(currentStep){
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        modifier = Modifier,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        text = stringResource(R.string.tap_lemon_tree),
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        modifier = Modifier,
                        colors = buttonColors(colorResource(id = R.color.Blue_Shade)),
                        shape = RoundedCornerShape(18.dp),
                        onClick = {
                            currentStep = 2
                        }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.lemon_tree_content_description),
                            modifier = Modifier
                                .wrapContentSize()

                        )
                    }
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(modifier = Modifier,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        text = stringResource(R.string.lemon_squeeze))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Button(
                        modifier = Modifier,
                        colors = buttonColors(colorResource(id = R.color.Blue_Shade)),
                        shape = RoundedCornerShape(18.dp),
                        onClick = {
                            squeezeCount++
                            if (squeezeCount == 10) {
                                currentStep = 3
                                squeezeCount = 0
                            } }) {
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.lemon_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                }
            }
            3->{
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(modifier = Modifier,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        text = stringResource(R.string.lemon_drink))
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier,
                        colors = buttonColors(colorResource(id = R.color.Blue_Shade)),
                        shape = RoundedCornerShape(18.dp),
                        onClick = { currentStep = 4 }) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.lemonade_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                }
            }
            else -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(modifier = Modifier,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        text = stringResource(R.string.lemon_empty_glass))
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier,
                        colors = buttonColors(colorResource(id = R.color.Blue_Shade)),
                        shape = RoundedCornerShape(18.dp),
                        onClick = { currentStep = 1 }) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.empty_glass_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true,
    name = "Lemonade Application")
@Composable
fun LemonPreview() {
    LemonadeTheme{
        LemonadeApp()
    }
}