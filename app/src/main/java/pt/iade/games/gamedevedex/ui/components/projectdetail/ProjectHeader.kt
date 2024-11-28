package pt.iade.games.gamedevedex.ui.components.projectdetail

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.ProjectDetailScreen
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun ProjectHeader(
    project: Project,
    onMemberClick: (Student) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 35.dp)
    ) {
        AsyncImage(
            model = project.assets[0].asset,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 250.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(0.dp, 35.dp)
        ) {
            project.groupMembers.forEach { member ->
                Spacer(modifier = Modifier.width(8.dp))
                AsyncImage(
                    model = member.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.outline, CircleShape)
                        .clickable { onMemberClick(member) } // Open popup on click
                )
            }
        }
    }
}

@Preview
@Composable
fun ProjectDetailHeaderPreview() {
    ProjectHeader (
        onMemberClick = { },
        project=Project(
            title = "Operation Silent Chaos",
            votes = 120,
            description = "Sneak through a cold war era setting, avoiding detection and completing espionage missions!",
            genre="Single-player, Top-down 2D Stealth game",
            platform="Windows PC/ Companion App: Android (Optional)",
            id = 404,
            semester = 3,
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
            ),
            groupMembers = listOf(
                Student(
                    id = 123,
                    name = "Maurice Dolibois",
                    biography = "Hey im Erasmus Student from Germany",
                    mood = "Happy",
                    avatar = R.drawable.profile
                ),
                Student(
                    id = 124,
                    name = "Guilherme",
                    biography = "I'm a student at IADE",
                    mood = "Lucky",
                    avatar = R.drawable.profile
                ),
                Student(
                    id = 125,
                    name = "Pedro",
                    biography = "I'm a student at IADE",
                    mood = "Yolo",
                    avatar = R.drawable.profile
                )
            )
        )
    )
}