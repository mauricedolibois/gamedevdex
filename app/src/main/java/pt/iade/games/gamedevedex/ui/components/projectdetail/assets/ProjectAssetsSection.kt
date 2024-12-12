package pt.iade.games.gamedevedex.ui.components.projectdetail.assets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.ProjectAsset

@Composable
fun ProjectAssetsSection(assets: List<ProjectAsset>) {
    var selectedAsset by remember { mutableStateOf<ProjectAsset?>(null) }

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Project Assets:",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        // Show all assets except the first one
        assets.subList(1, assets.size).chunked(2).forEach { rowAssets ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowAssets.forEach { asset ->
                    Box(
                        modifier = if (rowAssets.size == 1) {
                            Modifier.fillMaxWidth()
                        } else {
                            Modifier.weight(1f)
                        }
                            .aspectRatio(1f)
                            .height(100.dp)
                            .clickable { selectedAsset = asset }
                    ) {
                        AsyncImage(
                            model = asset.asset,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = (if (rowAssets.size == 1) ContentScale.FillWidth else ContentScale.Crop)
                        )
                    }
                }
                // If fewer than 2 items, fill the remaining space
                if (rowAssets.size < 2) {
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }

    // Popup dialog for selected asset
    selectedAsset?.let { asset ->
        Dialog(onDismissRequest = { selectedAsset = null }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surface
            ) {
                ProjectAssetCard(asset)
            }
        }
    }
}

@Preview
@Composable
fun ProjectAssetsPreview() {
    ProjectAssetsSection(
        assets = listOf(
            ProjectAsset(
                asset = R.drawable.title,
                description = "Project Card"
            ),
            ProjectAsset(
                asset = R.drawable.outside,
                description = "Explore the map!"
            ),
            ProjectAsset(
                asset = R.drawable.inside,
                description = "Don't get caught!"
            ),
            ProjectAsset(
                asset = R.drawable.specsheet,
                description = "Game Spec Sheet"
            )
        )
    )
}
