# Документация API

## **/api/1/adapter**

### Параметры JSON запроса:
| Параметр    | Тип    | Описание                                                   |
|-------------|--------|------------------------------------------------------------|
| msg         | string | Текстовое сообщение.  Не может быть пустым.                |
| lng         | string | Язык сообщения.  Должен быть равен "ru".                   |
| coordinates | object | Координаты. Содержит в себе параметры "Широта" и "Долгота" |
| latitude    | string | Широта                                                     |
| longitude   | string | Долгота                                                    |

### Пример JSON:
```
{
  "msg": "Привет",
  "lng": "ru",
  "coordinates": {
    "latitude": "54.35",
    "longtitude": "52.52"
  }
}
```