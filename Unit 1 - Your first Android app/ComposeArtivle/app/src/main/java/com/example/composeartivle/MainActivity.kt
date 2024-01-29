package com.example.composeartivle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeartivle.ui.theme.ComposeArtivleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArtivleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        MyWriter(
                            header = stringResource(R.string.header_text),
                            paragraph1 = stringResource(R.string.paragraph_text_1),
                            paragraph2 = stringResource(R.string.paragraph_text_2)
                        )
                    }

                }
            }
        }
    }
}



@Composable
fun MyWriter(header: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column (modifier = modifier){
        Image(painter = image, contentDescription = null)
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = paragraph1,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = paragraph2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArtivleTheme {

        MyWriter(
            header = stringResource(R.string.header_text),
            paragraph1 = stringResource(R.string.paragraph_text_1),
            paragraph2 = stringResource(R.string.paragraph_text_2)
        )

    }
}

