import React, {useEffect, useRef, useState} from 'react';
import {MenuItem, TextField} from "@mui/material";
import cls from "./AddProduct.module.css"
import placeholder from "../../icons/placeholder.png"
import {booleans, brands, categories, producers} from "../../constants/commonConstants";
import PrimaryButton from "../../components/UI/primaryButton/PrimaryButton";
import AdminRepository from "../../repository/AdminRepository";
import ErrorBlock from "../../components/errorBlock/ErrorBlock";

const AddProductPage = () => {
    const inputImageReference = useRef()
    const [globalError, setGlobalError] = useState(false)

    const [productName, setProductName] = useState("")
    const [forAdults, setForAdults] = useState(booleans[1].value)
    const [inStock, setInStock] = useState("")
    const [price, setPrice] = useState("")
    const [categoryName, setCategoryName] = useState(categories[0])
    const [producerName, setProducerName] = useState(producers[0])
    const [brandName, setBrandName] = useState(brands[0])
    const [calories, setCalories] = useState("")
    const [proteins, setProteins] = useState("")
    const [carbohydrates, setCarbohydrates] = useState("")
    const [fats, setFats] = useState("")
    const [description, setDescription] = useState("")
    
    const [file, setFile] = useState()
    const [fileUrl, setFileUrl] = useState(placeholder)

    const handleFileChange = (e) => {
        if (e.target.files) {
            setFile(e.target.files[0]);
        }
    };

    useEffect(() => {
        if (file) setFileUrl(URL.createObjectURL(file))
    }, [file])

    const applyProcess = () => {
        const formData = new FormData();
        if (file) formData.append("picture", file)
        formData.append(
            "product",
            new Blob([JSON.stringify({
                product_name : productName,
                for_adults : forAdults === 'true',
                in_stock : inStock === 'true',
                price : price,
                category_name : categoryName,
                brand_name : brandName,
                producer_name : producerName,
                calories : calories,
                proteins : proteins,
                fats : fats,
                description : description,
                carbohydrates : carbohydrates
            })], {type: "application/json"})
        )
        AdminRepository.addProduct(formData).then(() => {
            setGlobalError(false)
        }, () => {
            setGlobalError(true)
        })
    }

    return (
        <div className={cls.mainContainer}>
            <div className={cls.textFieldsContainer}>
                <TextField margin="normal" value={productName} label="Название" variant="outlined" onChange={e => setProductName(e.target.value)}/>
                <TextField className={cls.selector} defaultValue={booleans[1].value} margin="normal" select label="Для взрослых">
                    { booleans.map((option) => (
                        <MenuItem key={option.value} value={option.value} onClick={e => setForAdults(option.value)}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField className={cls.selector} defaultValue={booleans[1].value} margin="normal" select label="В наличии">
                    { booleans.map((option) => (
                        <MenuItem key={option.value} value={option.value} onClick={e => setInStock(option.value)}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField margin="normal" value={price} label="Цена" variant="outlined" onChange={e => setPrice(e.target.value)}/>
                <TextField className={cls.selector} defaultValue={categories[0]} margin="normal" select label="Категория">
                    { categories.map(category => (
                        <MenuItem key={category} value={category} onClick={e => setCategoryName(category)}>
                            {category}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField className={cls.selector} defaultValue={producers[0]} margin="normal" select label="Производитель">
                    { producers.map(producer => (
                        <MenuItem key={producer} value={producer} onClick={e => setProducerName(producer)}>
                            {producer}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField className={cls.selector} defaultValue={brands[0]} margin="normal" select label="Бренд">
                    { brands.map(brand => (
                        <MenuItem key={brand} value={brand} onClick={e => setBrandName(brand)}>
                            {brand}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField margin="normal" value={calories} label="Калории" variant="outlined" onChange={e => setCalories(e.target.value)}/>
                <TextField margin="normal" value={proteins} label="Белок" variant="outlined" onChange={e => setProteins(e.target.value)}/>
                <TextField margin="normal" value={carbohydrates} label="Углеводы" variant="outlined" onChange={e => setCarbohydrates(e.target.value)}/>
                <TextField margin="normal" value={fats} label="Жиры" variant="outlined" onChange={e => setFats(e.target.value)}/>
                <TextField margin="normal" multiline maxRows={10} value={description} label="Описание" variant="outlined" onChange={e => setDescription(e.target.value)}/>
            </div>
            <div>
                <input ref={inputImageReference} hidden type="file" onChange={handleFileChange}/>
                <img src={fileUrl} alt={""} className={cls.addingProductPicture} onClick={() => inputImageReference.current.click()}/>
                { globalError && <div style={{marginTop:"8px"}}><ErrorBlock><h1>Проверьте введённые данные</h1></ErrorBlock></div> }
                <div className={cls.applyButtonContainer}>
                    <PrimaryButton onClick={applyProcess}>
                        <span>Сохранить</span>
                    </PrimaryButton>
                </div>
            </div>
        </div>
        
    );
};

export default AddProductPage;