package pt.iade.games.gamedevedex.ui.components.projectdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Student

@Composable
fun StudentCard(student: Student) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Image
            AsyncImage(
                model = student.avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            //details
            Text(
                text = student.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = student.biography,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Mood: ${student.mood}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun StudentCardPreview() {
    StudentCard(
        student = Student(
            id = 1,
            name = "Student Name",
            avatar = R.drawable.profile,
            biography = "Sample biography. This is where we can describe the student briefly.",
            mood = "Happy"
        )
    )
}
