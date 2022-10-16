package com.nauhalf.thirtydaysinteyvat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nauhalf.thirtydaysinteyvat.data.TeyvatJourneyDataSource
import com.nauhalf.thirtydaysinteyvat.model.TeyvatJourney
import com.nauhalf.thirtydaysinteyvat.ui.theme.ThirtyDaysInTeyvatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysInTeyvatApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirtyDaysInTeyvatApp() {
    ThirtyDaysInTeyvatTheme {
        Scaffold {
            TeyvatJourneyList()
        }
    }
}

@Composable
fun TeyvatJourneyList(modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(TeyvatJourneyDataSource.list) { item ->
            TeyvatJourneyCard(teyvatJourney = item)
        }
    }
}

@Composable
fun TeyvatJourneyCard(teyvatJourney: TeyvatJourney, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TeyvatJourneyTitle(
                text = stringResource(id = teyvatJourney.titleRes),
                modifier = Modifier,
            )
            TeyvatJourneyPhoto(
                image = painterResource(id = teyvatJourney.imageRes),
                title = stringResource(
                    id = teyvatJourney.titleRes),
                modifier = Modifier,
            )
            TeyvatJourneyDescription(
                description = stringResource(id = teyvatJourney.descriptionRes),
                modifier = Modifier,
            )
        }
    }
}

@Composable
fun TeyvatJourneyTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
    )
}

@Composable
fun TeyvatJourneyPhoto(image: Painter, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Image(painter = image, contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TeyvatJourneyDescription(description: String, modifier: Modifier = Modifier) {
    Text(text = description, modifier = modifier)
}
