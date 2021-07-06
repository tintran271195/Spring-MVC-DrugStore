class App {
    static BASE_URL_MEDICINE = "http://localhost:8080/api/medicines"
    static BASE_URL_CATEGORY = "http://localhost:8080/api/categories"

    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}

class Medicine {
    constructor(id, name, unit, price, category) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
    }
}