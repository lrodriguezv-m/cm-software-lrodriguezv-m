# cm-software-lrodriguezv-m


1er Parte Construcción Proyecto

- 1: Se crearon los metodos reduceQuality(Item item) y increaseQuality(Item item), para reducir la repeticion (DRY)
- 2: Se anadieron varios metodos para las condiciones de los if, para ayudar con la legibilidad y la mantenibilidad
- 3: Se cambio la linea 'items[i].quality - items[i].quality' por '0' y se cambio el for inicial por un foreach, para 
ayudar con la legibilidad
- 4: Se crearon varios metodos para encapsular las reglas del negocio para aplicar los principios de KISS, Legibilidad, 
Mantenibilidad, y retutilizacion de componentes.
- 5. Se creao una interfaz IQualityService y un servicio que implementa la interfaz QualityServiceImpl para lograr mayor 
modularizacion y menor acoplacion
