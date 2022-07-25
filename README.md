# Pokemon Test

Prueba de consumo de api PokeAPI

## Error

Existe un error al llamar launchScope en el método launchWhenResumed que sucede cuando se presiona en el item de cada Pokemon. Esto hace que solo se pueda acceder desde el inicio y no desde favoritos. Solo se puede acceder al pokemon desde favoritos cuando se inicia la aplicación y todavía no se ha lanzado el diálogo desde inicio. Comparto código para más detalles

```kotlin
lifecycleScope?.launchWhenResumed {
            pokemon?.let {
                dialog.arguments = getArguments(it)
                fragmentManager?.let { f ->
                    dialog.show(f, "PokemonDetail")
                }
            }
        }
```

## Detalles
- Arquitectura: Se eligió MVP ya que no se requería la programación reactiva
- Patrones de diseño: Se han usado las clases del repositorio como adaptadores para que la aplicación no dependa de los servicios, de forma que si se requiriera cambiar de API en el futuro, se pueda realizar desde cero. Acionalmente se usó un Sigleton para un Interactor ya que requería de constante uso.
- Se ha utilizado la librería de Retrofit para consumo de datos
- Se ha utilizado FireBase para consulta de datos y para autenticación de usuario. FireStore también permite almacenar los datos de forma local
## License
[MIT](https://choosealicense.com/licenses/mit/)