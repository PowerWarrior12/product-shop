import human from '../icons/human.svg'
import bag from '../icons/bag.svg'
import logout from '../icons/logout.svg'
import settings from '../icons/settings.svg'
import plus from '../icons/plus.svg'
import money from '../icons/money.svg'
export const sorts = [
    {
        title: "По цене",
        value: "price"
    },
    {
        title: "По алфавиту",
        value: "productName"
    },
    {
        title: "Нет",
        value: null
    }
]

export const accountMenuItems = [
    {
        title: "Личные данные",
        value: "personal",
        image: human
    },
    {
        title: "Заказы",
        value: "orders",
        image: bag
    },
    {
        title: "Поддержка",
        value: "help",
        image: human
    },
    {
        title: "Выйти из аккаунта",
        value: "logout",
        image: logout
    }
]

export const adminMenuItems = [
    {
        title: "Личные данные",
        value: "personal",
        image: human
    },
    {
        title: "Заказы",
        value: "orders",
        image: bag
    },
    {
        title: "Поддержка",
        value: "help",
        image: human
    },
    {
        title: "Настроить продукты",
        value: "productsSetup",
        image: settings
    },
    {
        title: "Добавить продукт",
        value: "addProduct",
        image: plus
    },
    {
        title: "Заказы пользователей",
        value: "customersOrders",
        image: money
    },
    {
        title: "Выйти из аккаунта",
        value: "logout",
        image: logout
    }
]

export const booleans = [
    {
        label: "Да",
        value: 'true'
    },
    {
        label: "Нет",
        value: 'false'
    }
]

export const brands = [
    "Золотой стандарт",
    "Серебряный стандарт",
    "Магия",
    "Корова несушка",
    "Магуайр",
    "Ролс Роликс",
    "Рыжая собака"
]

export const producers = [
    "Северный завод",
    "Нижне-Верхний уральский металостроительный комбинат",
    "Урюк",
    "Ванечкин садик",
    "УлГТУ",
    "ИП Жора",
    "Красная икра со скидкой"
]

export const categories = [
    "Яйца",
    "Молоко",
    "Хлеб",
    "Творог",
    "Шоколад",
    "Варенье",
    "Мясо"
]