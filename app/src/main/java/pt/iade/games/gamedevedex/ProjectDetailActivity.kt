package pt.iade.games.gamedevedex

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.projectdetail.DescriptionCard
import pt.iade.games.gamedevedex.ui.components.projectdetail.assets.ProjectAssetsSection
import pt.iade.games.gamedevedex.ui.components.projectdetail.ProjectHeader
import pt.iade.games.gamedevedex.ui.components.shared.ProjectTopBar
import pt.iade.games.gamedevedex.ui.components.projectdetail.StudentCard

class ProjectDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val project = intent.getParcelableExtra<Project>("project_key")
        setContent {
            if (project != null) {
                ProjectDetailScreen(project)
            } else {
                val context = LocalContext.current
                ProjectTopBar(
                    title = "Project not found",
                    onBackClick = {
                        val intent = Intent(context, MainActivity::class.java).apply {}
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun ProjectDetailScreen(project: Project) {
    val context = LocalContext.current
    var selectedStudent by remember { mutableStateOf<Student?>(null) } // State for selected student

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ProjectTopBar(
                title = project.title,
                onBackClick = {
                    val intent = Intent(context, MainActivity::class.java).apply {}
                    context.startActivity(intent)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ProjectHeader(
                project = project,
                onMemberClick = { selectedStudent = it }
            )
            Column(modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                DescriptionCard(project)
                Spacer(modifier = Modifier.height(16.dp))
                ProjectAssetsSection(project.assets)
            }
        }
    }

    selectedStudent?.let { student ->
        Dialog(onDismissRequest = { selectedStudent = null }) { //close when press outside
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surface
            ) {
                StudentCard(student = student)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProjectDetailScreenPreview() {
    ProjectDetailScreen(
        project = Project(
            title = "Among Us",
            votes = 2,
            genre = "Single-player, Top-down 2D Stealth game",
            platform = "Windows PC/ Companion App: Android (Optional)",
            description = "Super sus.",
            id = 404,
            semester = 1,
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

@Preview
@Composable
fun ProjectDetailScreenPreviewProject() {
    ProjectDetailScreen(
        project = Project(
            title = "Among Us",
            votes = 2,
            genre = "Single-player, Top-down 2D Stealth game",
            platform = "Windows PC/ Companion App: Android (Optional)",
            description = "Super sus.",
            id = 404,
            semester = 1,
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