package com.example.treninterurbano.ui.screens.schedules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Train
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen() {
    // Datos de ejemplo
    val stations = listOf(
        "Todas las estaciones",
        "Estación Central",
        "Estación Norte",
        "Estación Sur",
        "Estación Este",
        "Estación Oeste"
    )
    
    val routes = listOf(
        "Todas las rutas",
        "Línea Principal",
        "Línea Norte",
        "Línea Sur",
        "Alimentadora 1",
        "Alimentadora 2"
    )
    
    val schedules = listOf(
        ScheduleItem("Línea Principal", "Estación Central", "Estación Terminal", "08:00", "08:25", "#1976D2"),
        ScheduleItem("Línea Principal", "Estación Central", "Estación Terminal", "08:15", "08:40", "#1976D2"),
        ScheduleItem("Línea Principal", "Estación Central", "Estación Terminal", "08:30", "08:55", "#1976D2"),
        ScheduleItem("Línea Norte", "Estación Norte", "Estación Noreste", "08:10", "08:28", "#4CAF50"),
        ScheduleItem("Línea Norte", "Estación Norte", "Estación Noreste", "08:25", "08:43", "#4CAF50"),
        ScheduleItem("Línea Sur", "Estación Sur", "Estación Suroeste", "08:05", "08:27", "#FF9800"),
        ScheduleItem("Línea Sur", "Estación Sur", "Estación Suroeste", "08:20", "08:42", "#FF9800")
    )
    
    var selectedStation by remember { mutableStateOf(stations[0]) }
    var selectedRoute by remember { mutableStateOf(routes[0]) }
    var expandedStationMenu by remember { mutableStateOf(false) }
    var expandedRouteMenu by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
        ) {
            Text(
                text = "Horarios de Trenes",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        
        // Filters
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Filtrar Horarios",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Station filter
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Estación",
                            style = MaterialTheme.typography.bodySmall
                        )
                        
                        Box {
                            OutlinedButton(
                                onClick = { expandedStationMenu = true },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = selectedStation,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Seleccionar Estación"
                                )
                            }
                            
                            DropdownMenu(
                                expanded = expandedStationMenu,
                                onDismissRequest = { expandedStationMenu = false },
                                modifier = Modifier.fillMaxWidth(0.9f)
                            ) {
                                stations.forEach { station ->
                                    DropdownMenuItem(
                                        text = { Text(station) },
                                        onClick = {
                                            selectedStation = station
                                            expandedStationMenu = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    // Route filter
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Ruta",
                            style = MaterialTheme.typography.bodySmall
                        )
                        
                        Box {
                            OutlinedButton(
                                onClick = { expandedRouteMenu = true },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = selectedRoute,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Seleccionar Ruta"
                                )
                            }
                            
                            DropdownMenu(
                                expanded = expandedRouteMenu,
                                onDismissRequest = { expandedRouteMenu = false },
                                modifier = Modifier.fillMaxWidth(0.9f)
                            ) {
                                routes.forEach { route ->
                                    DropdownMenuItem(
                                        text = { Text(route) },
                                        onClick = {
                                            selectedRoute = route
                                            expandedRouteMenu = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            selectedStation = stations[0]
                            selectedRoute = routes[0]
                        }
                    ) {
                        Text("Limpiar Filtros")
                    }
                }
            }
        }
        
        // Schedules list
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // Filter schedules based on selection
            val filteredSchedules = schedules.filter {
                (selectedStation == stations[0] || it.departureStation == selectedStation || it.arrivalStation == selectedStation) &&
                (selectedRoute == routes[0] || it.route == selectedRoute)
            }
            
            if (filteredSchedules.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay horarios disponibles con los filtros seleccionados",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(filteredSchedules) { schedule ->
                    ScheduleCard(schedule = schedule)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
            
            // Bottom spacing
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun ScheduleCard(
    schedule: ScheduleItem
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Route info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color(android.graphics.Color.parseColor(schedule.color))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Train,
                        contentDescription = "Train",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = schedule.route,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Divider()
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Departure info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Departure",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Salida",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Text(
                        text = schedule.departureStation,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = "Time",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(4.dp))
                
                Text(
                    text = schedule.departureTime,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Arrival info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Arrival",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Llegada",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Text(
                        text = schedule.arrivalStation,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = "Time",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(4.dp))
                
                Text(
                    text = schedule.arrivalTime,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Clase de datos para la demostración
data class ScheduleItem(
    val route: String,
    val departureStation: String,
    val arrivalStation: String,
    val departureTime: String,
    val arrivalTime: String,
    val color: String
)

