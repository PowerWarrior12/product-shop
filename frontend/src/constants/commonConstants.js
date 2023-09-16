import human from '../icons/human.svg'
import bag from '../icons/bag.svg'
import logout from '../icons/logout.svg'
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
        value: "personal_data",
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