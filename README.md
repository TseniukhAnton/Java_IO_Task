Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:

model.Team(id, name, List<Developer> developers)
Developer(id, firstName, lastName, List<model.Skill> skills)
model.Skill(id, name)
TeamStatus (enum ACTIVE, DELETED)

В качестве хранилища данных необходимо использовать текстовые файлы:
teams.json, developers.json, skills.json
Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.
Слои:
model - POJO классы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью

Например: model.Team, TeamRepository, TeamController, TeamView и т.д.
Для репозиторного слоя желательно использовать базовый интерфейс:
interface GenericRepository<T,ID>



interface TeamRepository extends GenericRepository<model.Team, Long>

class GsonTeamRepositoryImpl implements TeamRepository
