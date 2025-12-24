
# 🐸 Anfibios App

Aplicación Android moderna para la visualización y gestión de datos de anfibios, construida con **Jetpack Compose** y arquitectura **MVVM**.

<p align="center">
  <img src="https://github.com/NinaDIV/Anfibios/blob/main/IMG/IMG.png?raw=true" alt="Pantalla de inicio " width="300">
</p>


## 🛠️ Stack Tecnológico
* **Lenguaje:** Kotlin / Java
* **UI:** Jetpack Compose (Material 3)
* **Arquitectura:** MVVM (LiveData, ViewModel)
* **Carga de Imágenes:** Coil
* **Build System:** Gradle

---

## ▶️ Ejecutar la aplicación

### Opción 1: Android Studio (recomendado)

1. **Abrir el proyecto**
   - Abre **Android Studio**
   - Selecciona la carpeta **`Anfibios`**
   - Espera a que finalice la **sincronización de Gradle**

2. **Ejecutar la app**
   - Conecta un dispositivo físico **o** inicia un emulador
   - Presiona:
     - `Shift + F10`, o
     - el botón **Run ▶️**

📱 La aplicación se instalará y ejecutará automáticamente.  

---

### Opción 2: Terminal

#### Instalar la app en un dispositivo o emulador
 

```bash
./gradlew installDebug


```
---

## 📂 Estructura Principal

* `MVVM.View`: Pantallas y componentes de UI (Compose).
* `MVVM.ViewModel`: Lógica de negocio y estado de la UI.
* `MVVM.Model`: Modelos de datos (Amphibian).

---

> **Nota:** No olvides configurar tu `local.properties` con la ruta de tu SDK de Android.


