                  # Варианты работы с разными структурами данных(колекциями) из .properties файлов
                      
                      
``1.`` В application.properties имеем слудующую конфигурацю:                   

- driverDocType2Category.MOTO=A
- driverDocType2Category.CAR=B
- driverDocType2Category.TRUCK=C
- driverDocType2Category.BUS=D

Задача - получить карту **Map<String, String>**, где ключом будет название категории, а значением его обозначениее.

- создаем класс CollectionsPropertyUtils, который будет бином, + сканировать наши проперти и название наших строк.

```
@Getter
@Component
@ConfigurationProperties()
public class CollectionsPropertyUtils {

    public final Map<String, String> driverDocType2Category = new HashMap<>();

}
```
С помощью аннотации @ConfigurationProperties() мы можем срузу инициадизировать нужную карту, обращаясь к блоку конфигураций
по имени driverDocType2Category. Имя карты должно совпадать с названием проперти из файла. в данном случае :

driverDocType2Category.MOTO=A


**Для работы данной анотации спринг бут попросит вас добавить зависимость**
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
</dependency>
```

Теперь сделаем сервис куда мы будем инжектить наш бин в котором будем  работать с нашей структурой данных, получив
карту с помощью гетера

```
@Component
public class PropertiesService {

    private final CollectionsPropertyUtils collectionsPropertyUtils;

    @Autowired
    public PropertiesService(CollectionsPropertyUtils collectionsPropertyUtils) {
        this.collectionsPropertyUtils = collectionsPropertyUtils;
    }

    void mapFromProperties() {
        Map<String, String> driverDocType2CategoryMap = collectionsPropertyUtils.getDriverDocType2Category();
        driverDocType2CategoryMap.forEach((k, v) -> System.out.println(k + " ->" + v));
    }
}
```

Результатом выполнения будет:
- MOTO ->A
- TRUCK ->C
- BUS ->D
- CAR ->B


Аналогичным способом получаяем из .properties файла, карту - где значениеми будет выступать уже список параметров.
``2.`` В application.properties имеем слудующую конфигурацю:     
- driverDocType2Categories.MOTO=A,A1,A2
- driverDocType2Categories.CAR=B,B1,B2
- driverDocType2Categories.TRUCK=C.C1,C2
- driverDocType2Categories.BUS=D,D1,D2

После равно, видим список значений

Задача - получить карту **Map<String, List<String>>**, где ключом будет название категории, а значением - набор значений.

```
@Getter
@Component
@ConfigurationProperties()
public class CollectionsPropertyUtils {

     private final Map<String, List<String>> driverDocType2Categories = new HashMap<>();

}
```
```
@Component
public class PropertiesService {

    private final CollectionsPropertyUtils collectionsPropertyUtils;

    @Autowired
    public PropertiesService(CollectionsPropertyUtils collectionsPropertyUtils) {
        this.collectionsPropertyUtils = collectionsPropertyUtils;
    }

    void mapFromPropertiesWithListValues() {
           Map<String, List<String>> driverDocType2CategoriesMap = collectionsPropertyUtils.getDriverDocType2Categories();
           driverDocType2CategoriesMap.forEach((k, v) -> System.out.println(k + " ->" + v));
       }
}
```
Результатом выполнения будет:

- MOTO ->[A, A1, A2]
- TRUCK ->[C.C1, C2]
- BUS ->[D, D1, D2]
- CAR ->[B, B1, B2]



Теперь давайте получим, теже структуры данных. Но уже другим способом.

``3.`` В application.properties имеем слудующую конфигурацю:                   
- test.map={\
-  "key1":"value1",\
-  'key2':'value2',\
-   key3:'value3'\
- }

 **СИНТАКСИС** Все три ключа со значением, имеют разный синтаксис. Вы можете использовать любой вариант.


Что бы получить карту, нам всего лиш необходимо воспользоватся аннотацией **@Value**
```
    @Value("#{${test.map}}")
    private Map<String, String> testMap;
```

и метод который выводит содержимое карты(работаем все в том же сервисе)
```
    void mapFromPropertiesSecondOption() {
        testMap.forEach((k, v) -> System.out.println(k + " ->" + v));
    }
```

Результат выполнения:
- key1 ->value1
- key2 ->value2
- key3 ->value3


``4.``В application.properties имеем слудующую конфигурацю: 
   
- test.map.list.value={\
-  'KEY1': {'value1','value2'}, \
-  'KEY2': {'value3','value4'}, \
-  'KEY3': {'value5'} \
- }

```
 @Value("#{'${numberStringList}'.split(',')}")
    private List<String> numberStringList;
```
метод который выводит содержимое карты(работаем все в том же сервисе)

```
void mapFromPropertiesWithListValuesSecondOption() {
        testMapListValue.forEach((k, v) -> System.out.println(k + " ->" + v));
    }
```

Результат выполнения:
KEY1 ->[value1, value2]
KEY2 ->[value3, value4]
KEY3 ->[value5]




Задача - пулчить с помощью @Value лиш одно поле из карты

``5.1`` Если в файле .properties мы храним карту, при необходимости можем получить от туда только 
одно значение по ключю.
```
 @Getter
 @Component
 @ConfigurationProperties()
 public class CollectionsPropertyUtils {
 
 @Value("#{${test.map}.key3}")
    private String fieldFomMap;
   
  }
```

Метод для вывода
```
void valueFromMapByField() {
      System.out.println(fieldFomMap);
    }
```
 Результат выполнения:
 value3
 
 Задача - получить из .properties карту отсортированную по ключю либо по значению.
 
 ``5.2`` Теперь возьмем нашу карту и выведм ее, указав что не хотим в результате опирировать одним из ключей.
 
 ```
   @Getter
   @Component
   @ConfigurationProperties()
   public class CollectionsPropertyUtils {
       
        @Value("#{${test.map}.?[key!='key3']}")
        private Map<String, String> filteredTestMap;
      
    }
```
Метод для вывода 
```
  void filteredMap() {
        System.out.println(filteredTestMap);
    }
```
Результат выполнения:
{key1=value1, key2=value2}

``5.`` В application.properties имеем слудующую конфигурацю: 
      
- number.array=1,2,3,


```
  @Getter
  @Component
  @ConfigurationProperties()
  public class CollectionsPropertyUtils {
  
          @Value("${number.array}")
             private int [] numberArray;
 
   }
  ```

Задача - получить массив чисел.

``5.`` В application.properties имеем слудующую конфигурацю: 
      
- stringList=one,two,three

Метод для вывода 
```
 void arrayFromPropFile(){
         for (int i=0; i<numberArray.length;i++){
             System.out.println(numberArray[i]);
         }
     }
```

  Результат выполнения:
 -1
 -2
 -3
 -4

Задача - получить список **List<String>**.

``5.1`` . Получаем список, с помощью класса анотированого @ConfigurationProperties(), присвоив колекции имя
 которое совпадает с именем свойства в .properties файле.
 
  ```
  @Getter
  @Component
  @ConfigurationProperties()
  public class CollectionsPropertyUtils {
  
         private final List<String> numberStringList = new ArrayList<>();
 
   }
  ```
 
Метод для вывода 
```
  void listFromProperties() {
         collectionsPropertyUtils.getNumberStringList().forEach(System.out::println);
     }
```

  Результат выполнения:
  - one
  - two
  - three
  
``5.2`` С помощью аннотации **@Value и spell** выражения
 
 ```
 @Value("#{'${numberStringList}'.split(',')}")
     private List<String> numberStringList;
```

 Метод для проверки
  ```
  void listFromPropertiesSecondOption() {
         numberStringList.forEach(System.out::println);
     }
 ```
 Результат выполнения:
 - one
 - two
 - three
 
 ``6.`` В application.properties имеем слудующую конфигурацю: 
 
 - random.number=${random.int}
 - random.long=${random.long}
 - random.uuid=${random.uuid}
 
 Задача - получить объект  с полями number,long,uuid .
 В данном примере, использованна генереция значений к полях значений.
 
 Создаем ObjectPropertyConfigurator  сласс
 ```
 @Component
 @ConfigurationProperties(prefix = "random")
 @Getter
 @Setter
 @ToString
 public class ObjectPropertyConfigurator {
     String url;
     String username;
     String password;
 }
 ```
 
 
 Который является компонетом, имеет гетеры и сетеры. B основная аннотация:
 @ConfigurationProperties(prefix = "random") - которая говорит, что будет из всего списка пропертей
 вычитывать только с префиксом "random", а через точку будет название поля объекта

 в сервисе просто инжектим наш ObjectPropertyConfigurator

 
 ```
 @Component
 public class PropertiesService {
 
     private final ObjectPropertyConfigurator objectPropertyConfigurator;
 
     @Autowired
     public PropertiesService(ObjectPropertyConfigurator objectPropertyConfigurator) {
         this.objectPropertyConfigurator = objectPropertyConfigurator;
     }
 
     void objectFromProperties() {
             System.out.println(objectPropertyConfigurator.toString());
         }
 }
 ```
 
 Результат выполнения:
 ObjectPropertyConfigurator(url=55b4d1b054a8015b66e0604ccae2ac8e, username=aa2aace70946a0ceee6c0456432330f4, password=2b8704388fe69efd0ee7039fd299d02c)

 
 
 Пример конвертора который берет данные в одном формате и возврщает в другом.
  С гибкой возможностью выбора что конвертировать, а что нет. AddressTestService
  
  Исходный формат
  ```json
  [{"country":"Ukraine","city":"Dnipro","street":"Dniprova","house":"22","type":"1"},{"country":"Ukraine","city":"Dnipro","street":"Dniprova","house":"22","type":"2"},{"country":"Ukraine","city":"Dnipro","street":"Dniprova","house":"22","type":"3"},{"country":"Ukraine","city":"Dnipro","street":"Dniprova","house":"22","type":"4"}]
  ```
  
  выдаваемый формат:
  
  address_local_country - Ukraine
  address_local_city - Dnipro
  address_local_street - Dniprova
  address_local_house - 22
  address_foreign_country - Ukraine
  address_foreign_city - Dnipro
  address_foreign_street - Dniprova
  address_foreign_house - 22
  address_temporary_country - Ukraine
  address_temporary_city - Dnipro
  address_temporary_street - Dniprova
  address_temporary_house - 22
  address_former_country - Ukraine
  address_former_city - Dnipro
  address_former_street - Dniprova
  address_former_house - 22
  
  Исчерпывающая документация:
  https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-Configuration-Binding
