package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var artworkTitle by remember {
        mutableIntStateOf(R.string.artwork_title_1)
    }
    var artworkResourceId by remember {
        mutableIntStateOf(R.drawable.bogaz_koprusu)
    }
    var artworkArtist by remember {
        mutableIntStateOf(R.string.artwork_artist_1)
    }
    var artworkYear by remember {
        mutableIntStateOf(R.string.artwork_year_1)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxSize(),
    ) {

        Image(
            painter = painterResource(id = artworkResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .size(width = 350.dp, height = 425.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Yellow)


        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = artworkTitle),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = artworkArtist) + " | " + stringResource(id = artworkYear)
                ,  fontSize = 18.sp
            )

        }


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
        ) {
            Button(
                onClick = {
                    when (artworkResourceId) {
                        R.drawable.bogaz_koprusu -> {
                            artworkResourceId = R.drawable.galata
                            artworkTitle = R.string.artwork_title_3
                            artworkArtist = R.string.artwork_artist_3
                            artworkYear = R.string.artwork_year_3

                        }

                        R.drawable.galata -> {
                            artworkResourceId = R.drawable.anitkabir
                            artworkTitle = R.string.artwork_title_2
                            artworkArtist = R.string.artwork_artist_2
                            artworkYear = R.string.artwork_year_2
                        }

                        R.drawable.anitkabir -> {
                            artworkResourceId = R.drawable.bogaz_koprusu
                            artworkTitle = R.string.artwork_title_1
                            artworkArtist = R.string.artwork_artist_1
                            artworkYear = R.string.artwork_year_1
                        }


                    }

                },
                modifier = modifier.weight(40f)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = modifier.weight(20f))
            Button(onClick = {
                when (artworkResourceId) {
                    R.drawable.bogaz_koprusu -> {
                        artworkResourceId = R.drawable.anitkabir
                        artworkTitle = R.string.artwork_title_2
                        artworkArtist = R.string.artwork_artist_2
                        artworkYear = R.string.artwork_year_2

                    }

                    R.drawable.anitkabir -> {
                        artworkResourceId = R.drawable.galata
                        artworkTitle = R.string.artwork_title_3
                        artworkArtist = R.string.artwork_artist_3
                        artworkYear = R.string.artwork_year_3
                    }

                    R.drawable.galata -> {
                        artworkResourceId = R.drawable.bogaz_koprusu
                        artworkTitle = R.string.artwork_title_1
                        artworkArtist = R.string.artwork_artist_1
                        artworkYear = R.string.artwork_year_1
                    }
                }
            }, modifier = modifier.weight(40f)) {
                Text(text = "Next")
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}