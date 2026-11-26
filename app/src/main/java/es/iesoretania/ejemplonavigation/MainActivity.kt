package es.iesoretania.ejemplonavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import es.iesoretania.ejemplonavigation.databinding.ActivityMainBinding

/**
 * Única Activity de la app. Con Navigation Component la Activity solo hace de
 * "contenedor": las pantallas son Fragments que el NavController va cambiando.
 */
class MainActivity : AppCompatActivity() {

    // ViewBinding del layout activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // el NavController es el "conductor" que sabe navegar por el grafo
    private lateinit var navController: NavController

    // Indica qué destinos son de "nivel superior" (sin flecha de volver)
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dibujamos de borde a borde (detrás de las barras del sistema)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Insets: que el contenido no quede debajo de la cámara ni de las barras
        // del sistema. Sumamos además 16dp de margen interior.
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { vista, insets ->
            val barras = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            val extra = (16 * resources.displayMetrics.density).toInt() // 16dp -> px
            vista.setPadding(
                barras.left + extra,
                barras.top + extra,
                barras.right + extra,
                barras.bottom + extra
            )
            insets
        }

        // Usamos nuestra MaterialToolbar como ActionBar de la Activity
        setSupportActionBar(binding.toolbar)

        // obtenemos el NavController a partir del NavHostFragment.
        // OJO: en onCreate hay que buscarlo así (con el FragmentManager);
        // findNavController(R.id.nav_host_fragment) aquí falla con FragmentContainerView.
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // El destino inicial del grafo se considera "nivel superior" (sin flecha)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // Conecta la Toolbar con Navigation: el título cambia con el android:label
        // de cada destino y aparece la flecha "←" cuando no estamos en el inicio
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // qué hacer al pulsar la flecha "←" de la Toolbar (botón Up)
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
