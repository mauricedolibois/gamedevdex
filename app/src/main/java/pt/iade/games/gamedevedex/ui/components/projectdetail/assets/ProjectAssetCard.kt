package pt.iade.games.gamedevedex.ui.components.projectdetail.assets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.models.ProjectAsset

@Composable
fun ProjectAssetCard(asset: ProjectAsset) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = asset.asset,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp),
                contentScale = ContentScale.Fit
            )
            Text(asset.description,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}