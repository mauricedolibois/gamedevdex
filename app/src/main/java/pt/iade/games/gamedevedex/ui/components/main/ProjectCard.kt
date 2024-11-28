package pt.iade.games.gamedevedex.ui.components.main

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.ProjectDetailActivity
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    // var votes = project.votes
    var votes by remember { mutableIntStateOf(project.votes) }

    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            Toast.makeText(context, project.title, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ProjectDetailActivity::class.java).apply {
                putExtra("project_key", project)
            }
            context.startActivity(intent)
        }
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = project.assets[0].asset,
                placeholder = painterResource(R.drawable.placeholder_cover_image),
                contentDescription = "Cover image of the game",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "$votes",
                    fontSize = 17.sp,
                    color = Color(255, 255, 255)
                )
            }
        }

        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = project.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(weight = 1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Button(
                onClick = {
                    votes++
                    project.votes++
                },
                modifier = Modifier.padding(start = 30.dp)
            ) {
                Text("Vote")
            }
        }
    }
}

@Composable
@Preview()
fun ProjectCardPreview() {
    Column {
        ProjectCard(
            modifier = Modifier.padding(vertical = 20.dp),
            project = Project(
                title = "Operation Silent Chaos",
                votes = 120,
                description = "Next Level Stealth Game.",
                id = 404,
                genre="Single-player, Top-down 2D Stealth game",
                platform="Windows PC/ Companion App: Android (Optional)",
                semester = 3,
                assets = listOf(
                    ProjectAsset(
                        asset = R.drawable.title,
                        description = "Main game screen."
                    ),
                    ProjectAsset(
                        asset = R.drawable.specsheet,
                        description = "Emergency meeting screen."
                    )
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = R.drawable.profile
                    )
                )
            )
        )
        ProjectCard(
            modifier = Modifier.padding(vertical = 20.dp),
            project = Project(
                title = "Operation Silent Chaos",
                votes = 120,
                description = "Next Level Stealth Game.",
                id = 404,
                genre="Single-player, Top-down 2D Stealth game",
                platform="Windows PC/ Companion App: Android (Optional)",
                semester = 3,
                assets = listOf(
                    ProjectAsset(
                        asset = R.drawable.title,
                        description = "Main game screen."
                    ),
                    ProjectAsset(
                        asset = R.drawable.specsheet,
                        description = "Emergency meeting screen."
                    )
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = R.drawable.profile
                    )
                )
            )
        )
    }
}