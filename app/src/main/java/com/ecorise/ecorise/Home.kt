import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabTitles = listOf("Home", "Schedule", "Points", "Payment")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 70.dp)
            ) {

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(92.dp)
                ) {

                    Text(
                        text = tabTitles[selectedTab],
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF942222),
                        modifier = Modifier
                            .align(Alignment.Center)
                        .padding(top = 45.dp)
                    )

                    TopAppBarMenu(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 45.dp, end = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(86.dp))
                when (selectedTab) {
                    0 -> HomeContent()
                    1 -> ScheduleContent()
                    2 -> PointsContent()
                    3 -> PaymentContent()
                }
                Spacer(modifier = Modifier.weight(1f))
            }


            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomNavBar(selectedTab) { selectedTab = it }
            }
        }
    }
}

@Composable
fun TopAppBarMenu(modifier: Modifier = Modifier) {
    var menuExpanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        IconButton(onClick = { menuExpanded = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options",
                tint = Color(0xFF942222)
            )
        }
        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false },
            modifier = Modifier
                .background(
                    color = Color(0xFFDA6304),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            DropdownMenuItem(
                text = { Text("Chat with Ecobot", fontSize = 16.sp, color = Color.White) },
                onClick = { menuExpanded = false },
                modifier = Modifier.background(Color.Transparent)
            )
            DropdownMenuItem(
                text = { Text("Edit Profile", fontSize = 16.sp, color = Color.White) },
                onClick = { menuExpanded = false },
                modifier = Modifier.background(Color.Transparent)
            )
        }
    }
}


@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 30.dp)
    ) {
        HomeCard(icon = Icons.Default.Star, title = "Points", viewMore = "View more")
        Spacer(modifier = Modifier.height(38.dp))
        HomeCard(icon = Icons.Default.List, title = "Catalogue", viewMore = "View more")
        Spacer(modifier = Modifier.height(28.dp))
        HomeCard(icon = Icons.Default.CalendarToday, title = "Schedule request", viewMore = "View more")
        Spacer(modifier = Modifier.height(28.dp))
        HomeCard(icon = Icons.Default.Payment, title = "Payment", viewMore = "View more")
    }
}

@Composable
fun ScheduleContent() {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 40.dp), contentAlignment = Alignment.Center) {
        Text(text = "Schedule", color = Color(0xFF942222), fontSize = 22.sp)
    }
}

@Composable
fun PointsContent() {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 40.dp), contentAlignment = Alignment.Center) {
        Text(text = "Points", color = Color(0xFF942222), fontSize = 22.sp)
    }
}

@Composable
fun PaymentContent() {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 40.dp), contentAlignment = Alignment.Center) {
        Text(text = "Payment", color = Color(0xFF942222), fontSize = 22.sp)
    }
}

@Composable
fun HomeCard(icon: ImageVector, title: String, viewMore: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                width = 3.dp,
                color = Color(0xFF942222)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp, end = 10.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color(0xFF942222),
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.width(14.dp))
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF942222),
                modifier = Modifier.weight(1f)
            )

            Box(
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color(0xFF942222)), RoundedCornerShape(4.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .clickable { /* Handle View More click */ }
            ) {
                Text(
                    text = viewMore,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF942222)
                )
            }
        }
    }
}

@Composable
fun BottomNavBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val navIcons = listOf(
        Icons.Default.List,
        Icons.Default.CalendarToday,
        Icons.Default.Star,
        Icons.Default.Payment
    )
    val navLabels = listOf("Home", "Schedule", "Points", "Payment")

    Surface(
        color = Color(0xFFDA6304),
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(topStart = 11.dp, topEnd = 11.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            navIcons.indices.forEach { i ->
                BottomNavItem(
                    icon = navIcons[i],
                    label = navLabels[i],
                    isSelected = selectedTab == i,
                    onClick = { onTabSelected(i) }
                )
            }
        }
    }
}

@Composable
fun BottomNavItem(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 6.dp)
    ) {
        if (isSelected) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(44.dp)
                    .background(Color(0x157B2837), shape = CircleShape)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = Color(0xFF942222),
                    modifier = Modifier.size(32.dp)
                )
            }
        } else {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.White.copy(alpha = 0.75f),
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = label,
            fontSize = 15.sp,
            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
