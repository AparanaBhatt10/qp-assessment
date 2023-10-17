# qp-assessment
Small grocery booking application

This application covers below features (backend)

1) Admin controller who can check, manage inventory
2) Customer who can check the grocery items and create a order for different order with different quantity
3) Tech used: java 17,springboot,H2
4) Once the springboot project is run on localhost: h2 db can be accesses as follows : http://localhost:8080/grocery-booking-api/h2-console/  -> use password : password,created tables will be visible and can be queriedas well
5) When a customer creates an order and customer id is not present in that case a new customer is created and then the order is created.

# DB Tables
users : user entries (Admin/Customer)
grocery_category: categories of grocery items
grocery_orders: order details placed by a customer for given grocery items
order_items: details of individual grocery item in the order 
payment_details: if a user has placed the order : then payment is pending, entry of pending payment is provided in this table as soon as order is created, once the payment is completed , order is successfull, grocery items are updated accordingly

# API ENDPOINTS

# Update Products : By Admin

curl --location --request PUT 'http://localhost:8080/grocery-booking-api/admin/private/api/v1/items/{adminId}' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
      "id": 1,
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Biscuit",
      "brand": "Brittania",
      "mrp": 25.00,
      "discountPer": 1.00,
      "availableQty": 35,
      "category": 1,
      "inventoryLevel": "SUFFICIENT"
    },
    {
      "id": 2,
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "BiscuitChocolate",
      "brand": "CreamFills",
      "mrp": 70.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 1,
      "inventoryLevel": "LOW"
    },
    {
      "id": 3,
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Chips",
      "brand": "Lays",
      "mrp": 45.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 2,
      "inventoryLevel": "SUFFICIENT"
    },
    {
      "id": 4,
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Kurkure",
      "brand": "Brittania",
      "mrp": 50.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 2,
      "inventoryLevel": "SUFFICIENT"
    },
    {
      "id": 5,
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Bread",
      "brand": "Brittania",
      "mrp": 40.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 1,
      "inventoryLevel": "SUFFICIENT"
    }
  ]'
  
  
  
  
  
  Response: {
    "status": 1,
    "message": null,
    "listData": null,
    "count": null,
    "pageNo": null,
    "totalPages": null,
    "totalElements": null,
    "last": null,
    "data": "Success",
    "date": null
}




# ADD PRODUCTS 

curl --location --request POST 'http://localhost:8080/grocery-booking-api/admin/private/api/v1/items/add/{adminId}' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
      
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Biscuit",
      "brand": "Brittania",
      "mrp": 25.00,
      "discountPer": 1.00,
      "availableQty": 35,
      "category": 1,
      "inventoryLevel": "SUFFICIENT"
    },
    {
      
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "BiscuitChocolate",
      "brand": "CreamFills",
      "mrp": 70.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 1,
      "inventoryLevel": "LOW"
    },
    {
     
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Chips",
      "brand": "Lays",
      "mrp": 45.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 2,
      "inventoryLevel": "SUFFICIENT"
    },
    {
    
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Kurkure",
      "brand": "Brittania",
      "mrp": 50.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 2,
      "inventoryLevel": "SUFFICIENT"
    },
    {
      
      "createdDate": null,
      "status": true,
      "createdBy": null,
      "updatedDate": null,
      "updatedBy": null,
      "name": "Bread",
      "brand": "Brittania",
      "mrp": 90.00,
      "discountPer": 1.00,
      "availableQty": 51,
      "category": 1,
      "inventoryLevel": "SUFFICIENT"
    }
  ]'
  
  
  
  Response:
  {
    "status": 1,
    "message": null,
    "listData": null,
    "count": null,
    "pageNo": null,
    "totalPages": null,
    "totalElements": null,
    "last": null,
    "data": "Success",
    "date": null
}



// 


# GET List data Admin:

curl --location --request GET 'http://localhost:8080/grocery-booking-api/admin/private/api/v1/items/{pageNo}/{pageSize}'


Response: {
    "status": 0,
    "message": null,
    "listData": [
        {
            "id": 1,
            "createdDate": null,
            "status": true,
            "createdBy": 1,
            "updatedDate": 1697550397789,
            "updatedBy": null,
            "name": "Biscuit",
            "brand": "Brittania",
            "mrp": 25.00,
            "discountPer": 1.00,
            "availableQty": 35,
            "category": 1,
            "inventoryLevel": "SUFFICIENT"
        },
        {
            "id": 2,
            "createdDate": null,
            "status": true,
            "createdBy": 1,
            "updatedDate": 1697550397791,
            "updatedBy": null,
            "name": "BiscuitChocolate",
            "brand": "CreamFills",
            "mrp": 70.00,
            "discountPer": 1.00,
            "availableQty": 51,
            "category": 1,
            "inventoryLevel": "LOW"
        },
        {
            "id": 3,
            "createdDate": null,
            "status": true,
            "createdBy": 1,
            "updatedDate": 1697550397791,
            "updatedBy": null,
            "name": "Chips",
            "brand": "Lays",
            "mrp": 45.00,
            "discountPer": 1.00,
            "availableQty": 51,
            "category": 2,
            "inventoryLevel": "SUFFICIENT"
        },
        {
            "id": 4,
            "createdDate": null,
            "status": true,
            "createdBy": 1,
            "updatedDate": 1697550397791,
            "updatedBy": null,
            "name": "Kurkure",
            "brand": "Brittania",
            "mrp": 50.00,
            "discountPer": 1.00,
            "availableQty": 51,
            "category": 2,
            "inventoryLevel": "SUFFICIENT"
        },
        {
            "id": 5,
            "createdDate": null,
            "status": true,
            "createdBy": 1,
            "updatedDate": 1697550397791,
            "updatedBy": null,
            "name": "Bread",
            "brand": "Brittania",
            "mrp": 40.00,
            "discountPer": 1.00,
            "availableQty": 51,
            "category": 1,
            "inventoryLevel": "SUFFICIENT"
        }
    ],
    "count": null,
    "pageNo": 0,
    "totalPages": 2,
    "totalElements": 10,
    "last": false,
    "data": null,
    "date": null
}





# GET Data for customer:
curl --location --request GET 'http://localhost:8080/grocery-booking-api/customer/private/api/v1/items/{pageNo}/{pageSize}'


# CREATE customer order:

curl --location --request POST 'http://localhost:8080/grocery-booking-api/order/private/api/v1/create' \
--header 'Content-Type: application/json' \
--data-raw '{

    "orderItemsList":[{
        "qty":2,
        "groceryItemId":1,
         "mrp":25,
         "purchasePrice":24.75
    },{
        "qty":3,
        "groceryItemId":2,
         "mrp":75,
         "purchasePrice":74.25
    }],
    "totalItems":5,
    "totalPrice":272.25,
    "customerId":null,
    "customerMobile":"8638291045"
}'


Response:
{
    "orderItemsList": [
        {
            "qty": 2,
            "groceryItemId": 1,
            "mrp": 25,
            "purchasePrice": 24.75
        },
        {
            "qty": 3,
            "groceryItemId": 2,
            "mrp": 75,
            "purchasePrice": 74.25
        }
    ],
    "totalItems": 5,
    "totalPrice": 272.25,
    "customerId": 3,
    "customerMobile": "8638291045",
    "orderStatus": "CREATED",
    "orderId": 1
}
