## Final View

![resim](https://github.com/muhammeddincmdx/Kt8-LemonadeApp/assets/54439858/c3c1e353-9818-4d10-9041-f009349bf4de)


### Features and Notes
You can click the image. After clicking image and text will change.

````
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
````
