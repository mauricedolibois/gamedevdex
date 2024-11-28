package pt.iade.games.gamedevedex.ui.components.projectdetail.assets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.ProjectAsset

@Composable
fun ProjectAssetsSection(assets: List<ProjectAsset>) {
    Column {
        assets.drop(1).forEach { asset -> // skip the first asset as its the header
            ProjectAssetCard(asset)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun ProjectAssetsPrewiev() {
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
                description = "Dont get caught!"
            ),
            ProjectAsset(
                asset = R.drawable.specsheet,
                description = "Game Spec Sheet"
            )


        )
    )
}