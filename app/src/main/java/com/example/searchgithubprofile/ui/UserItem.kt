package com.example.searchgithubprofile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.searchgithubprofile.model.users.UserData
import coil.compose.rememberImagePainter
import com.example.searchgithubprofile.R
import com.example.searchgithubprofile.model.SearchItem

@Composable
fun UserItem(
    user: SearchItem.User,
    onClick: (SearchItem.User) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { onClick(user) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = if (user.avatarUrl != null) {
                rememberImagePainter(
                    data = user.avatarUrl,
                    builder = {
                        placeholder(R.drawable.place_holder_im)
                    }
                )
            } else {
                painterResource(id = R.drawable.user)
            },
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = user.login ?: "No login available",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Score: ${user.score}",
                    color = Color(0xFFEE8600)
                )
            }
        }
    }
}