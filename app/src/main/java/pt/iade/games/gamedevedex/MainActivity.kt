package pt.iade.games.gamedevedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.games.gamedevedex.controllers.StudentController
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.main.ProjectCard
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamedevedexTheme {
                MainView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    var student by remember { mutableStateOf<Student?>(null) }
    val studentController = StudentController()
    studentController.GetById(
        id = 123,
        onSuccess = { studentReq ->
            student = studentReq
        }
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Gamedevedex")
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            if (student != null) {
                Text(student!!.name)
            } else {
                // TODO: Show progress circle thingy.
            }

            ProjectCard(
                modifier = Modifier.padding(20.dp),
                project = ProjectExample()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainViewPreview() {
    GamedevedexTheme {
        MainView()
    }
}

fun ProjectExample(): Project {
    return Project(
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
                name = "Guilherme Alves",
                biography = "I'm a student at IADE",
                mood = "Lucky",
                avatar = R.drawable.profile
            ),
            Student(
                id = 125,
                name = "Pedro Simões",
                biography = "I'm a student at IADE",
                mood = "Yolo",
                avatar = R.drawable.profile
            )
        )
    )
}

