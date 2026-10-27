package com.podtiktok.mod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Accent = Color(0xFFFF2D55)
private val Background = Color(0xFF101010)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = Accent,
                    background = Background,
                    surface = Color(0xFF202020)
                )
            ) {
                var tab by remember { mutableIntStateOf(0) }
                var likes by remember { mutableIntStateOf(0) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Background)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "pod-tiktok-mod",
                        color = Accent,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = { tab = 0 }) {
                            Text("Для вас")
                        }
                        TextButton(onClick = { tab = 1 }) {
                            Text("Подписки")
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(
                                Color(0xFF29202D),
                                RoundedCornerShape(24.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("▶", fontSize = 64.sp, color = Accent)
                            Spacer(Modifier.height(16.dp))

                            Text(
                                text = if (tab == 0)
                                    "Твоя лента"
                                else
                                    "Твои подписки",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Видео появятся здесь",
                                color = Color.LightGray
                            )

                            Spacer(Modifier.height(24.dp))

                            Button(
                                onClick = { likes++ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Accent
                                )
                            ) {
                                Text("♥  Нравится: $likes")
                            }
                        }
                    }

                    NavigationBar(
                        containerColor = Color(0xFF181818)
                    ) {
                        NavigationBarItem(
                            selected = tab == 0,
                            onClick = { tab = 0 },
                            icon = { Text("⌂") },
                            label = { Text("Главная") }
                        )
                        NavigationBarItem(
                            selected = tab == 1,
                            onClick = { tab = 1 },
                            icon = { Text("♡") },
                            label = { Text("Подписки") }
                        )
                        NavigationBarItem(
                            selected = tab == 2,
                            onClick = { tab = 2 },
                            icon = { Text("●") },
                            label = { Text("Профиль") }
                        )
                    }
                }
            }
        }
    }
}
