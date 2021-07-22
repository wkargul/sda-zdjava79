* REST CRUD dla encji `Skill` z polami `name` (ID) i `description`
* REST CRUD dla encji `Employee` z polami `id` (ID), `firstName`, `lastName`, `birthDate` i `skills` (`Set<Skill>` wiele-do-wielu)
* DTO Employee zawiera `skills` jako `List<String>` (tylko nazwy)
* Parametr żądania: `retired`: `true` – tylko osoby **po** 60 roku życia, false – tylko osoby **przed** 60 rokiem życia, **domyślnie wszyscy**
* Parametr żądania: skills (`Set<String>`) – zawężenie wyników do osób z danymi umiejętnościami, **domyślnie wszyscy**
* Wykorzystaj dostarczony zalążek projektu
