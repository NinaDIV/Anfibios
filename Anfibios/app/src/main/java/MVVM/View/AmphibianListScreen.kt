package MVVM.View

import MVVM.MODEL.Amphibian
import MVVM.ViewModel.AmphibianViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianListScreen(viewModel: AmphibianViewModel) {
    // Observamos los datos
    val amphibians by viewModel.amphibians.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Amphibians Explorer",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        if (amphibians.isEmpty()) {
            // Estado de carga (Loading)
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    top = padding.calculateTopPadding() + 12.dp,
                    bottom = 12.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(amphibians) { amphibian ->
                    AmphibianCard(amphibian)
                }
            }
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian) {
    // Usamos Card elevada para mejor contraste
    ElevatedCard(
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            // Header del Card: Nombre y Tipo
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = amphibian.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Type: ${amphibian.type}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            // Imagen con Coil Moderno (AsyncImage)
            AsyncImage(
                model = amphibian.img_src,
                contentDescription = "Photo of ${amphibian.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp),
                contentScale = ContentScale.Crop
            )

            // Descripción con mejor tipografía
            Text(
                text = amphibian.description,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = androidx.compose.ui.unit.TextUnit.Unspecified,
                textAlign = androidx.compose.ui.text.style.TextAlign.Justify
            )
        }
    }
}