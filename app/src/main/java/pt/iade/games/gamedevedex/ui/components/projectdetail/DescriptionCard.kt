package pt.iade.games.gamedevedex.ui.components.projectdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun DescriptionCard(project: Project) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            // Genre
            Column(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Genre:",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = project.genre,
                    style = MaterialTheme.typography.bodyMedium ,
                    color = MaterialTheme.colorScheme.primary

                )
            }

            // Platform
            Column(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Platform:",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = project.platform,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary

                )
            }

            // Description
            Column {
                Text(
                    text = "Description:",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary

                )
            }
        }
    }
}

@Preview
@Composable
fun DescriptionCardPreview() {
    DescriptionCard(
        project = Project(
            title = "Operation Silent Chaos",
            votes = 120,
            description = "Sneak through a cold war era setting, avoiding detection and completing espionage missions!",
            genre = "Single-player, Top-down 2D Stealth game",
            platform = "Windows PC/ Companion App: Android (Optional)",
            id = 404,
            semester = 3,
            assets = listOf(
                ProjectAsset(
                    asset = R.drawable.title,
                    description = "Project Card"
                ),
                ProjectAsset(
                    asset = R.drawable.outside,
                    description = "Explore the map."
                ),
                ProjectAsset(
                    asset = R.drawable.inside,
                    description = "Don’t get caught."
                ),
                ProjectAsset(
                    asset = R.drawable.specsheet,
                    description = "Game Spec Sheet"
                )
            ),
            groupMembers = listOf(
                Student(
                    id = 123,
                    name = "Maurice Dolibois",
                    biography = "Hey, I'm an Erasmus student from Germany.",
                    mood = "Happy",
                    avatar = R.drawable.profile
                ),
                Student(
                    id = 124,
                    name = "Guilherme",
                    biography = "I'm a student at IADE.",
                    mood = "Lucky",
                    avatar = R.drawable.profile
                ),
                Student(
                    id = 125,
                    name = "Pedro",
                    biography = "I'm a student at IADE.",
                    mood = "Yolo",
                    avatar = R.drawable.profile
                )
            )
        )
    )
}
