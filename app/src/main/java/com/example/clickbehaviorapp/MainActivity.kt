package com.example.clickbehaviorapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehaviorapp.ui.theme.ClickBehaviorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickBehavior()
                }
            }
        }
    }
}

@Composable
fun ClickBehavior() {
    var clickNumber by remember{ mutableStateOf(0) }
    var currentStep by remember { mutableStateOf(1) }

    Surface(modifier = Modifier.fillMaxSize(),color=MaterialTheme.colorScheme.background) {
        when(currentStep){
            1->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize())
                {

                    Image(painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = stringResource(id = R.string.lemon_tree_string),
                        modifier= Modifier
                            .wrapContentSize()
                            .clickable {currentStep=2

                                 })
                    Spacer(modifier= Modifier.height(30.dp))
                    Text(text = stringResource(R.string.lemon_tree_string))
                }
            }


            2->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize())
                {
                    Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.keep_tapping_the_lemon_string),
                        modifier= Modifier
                            .wrapContentSize()
                            .clickable {

                                if (clickNumber<(1..5).random()){
                                clickNumber++

                            }else{
                                currentStep = 3
                            } },
                        )
                    Spacer(modifier= Modifier.height(30.dp))
                    Text(text = stringResource(R.string.keep_tapping_the_lemon_string))
                }
            }




            3->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize())
                {
                    Image(painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.tap_the_lemonade_to_drink_it_string),
                        modifier= Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 4 })
                    Spacer(modifier= Modifier.height(30.dp))
                    Text(text = stringResource(R.string.tap_the_lemonade_to_drink_it_string))
                }
            }


            4->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize())
                {
                    Image(painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.tap_the_empty_glass_to_start_again_string),
                        modifier= Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 1
                            clickNumber=0})
                    Spacer(modifier= Modifier.height(30.dp))
                    Text(text = stringResource(R.string.tap_the_empty_glass_to_start_again_string))
                }
            }

        }

    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ClickApp() {
    ClickBehaviorAppTheme {
        ClickBehavior()
    }
}