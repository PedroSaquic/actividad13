a)Identifica qué principio o patrón arquitectónico está violando y explica por qué.
Está violando el principio de separación de responsabilidades (SRP) y la arquitectura en capas (en concreto MVVM). 
Poner la lógica de red en MainActivity mezcla UI con lógica de acceso a datos: dificulta pruebas, mantenimiento y reutilización. 
También rompe Inversión de Dependencias (dependencias altas entre UI y capa de datos).

b)Describe cómo reorganizarías las clases siguiendo el patrón MVVM + Repository.
Model: clases de datos (Course, DTOs) + entidades del dominio.
Network / ApiService: interfaces Retrofit que definen endpoints (CourseApi).
RetrofitInstance (Singleton): construye y expone Retrofit / CourseApi.
Repository (CourseRepository): usa CourseApi para obtener datos, hace mapeos, caching, manejo de errores. Exponer funciones suspend fun getCourses() o fun getCourses(): Flow<List<Course>>.
ViewModel (CourseViewModel): llama al Repository, expone LiveData/StateFlow que la vista observa.
View (MainActivity / Fragment): observa ViewModel y renderiza la UI; no hace llamadas de red directas.

c)Menciona cuál de los componentes (Model, ViewModel, Repository) debería contener la instancia de Retrofit y por qué.
La instancia de Retrofit debería residir en una capa de infraestructura accesible desde el Repository — típicamente un RetrofitClient/NetworkModule como Singleton. Razones:
Evitar múltiples instancias (coste y configuración única).
Centralizar configuración (interceptors, timeouts, convertidores).
Facilitar inyección/mocking en tests (desde Repository se inyecta un CourseApi simulado).
En la práctica: RetrofitInstance (singleton) → crea CourseApi → CourseRepository recibe CourseApi.
