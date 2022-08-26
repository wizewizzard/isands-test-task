
# Liferay portal test task

##Demo 

**A video demo**

[Video demo](https://www.youtube.com/watch?v=8jDP9AfYvAE) 

***No sound. Turn the subtitles on.***

## Modules

Workspace consist of modules, among them are portlets, rest api module and service builder.

### Portlets

**Portlets** are grouped together in ***testtask*** category (when putting them site page). Portlets are:
- CRUD portlets to manage main tables, located in `estore-web` module. 
    - `DeviceTypePortlet`, `EmployeePositionPortlet`, `PurchaseTypePortlet` - portlets to manage secondary tables
    - `EmployeeCRUDPortlet`, `DeviceCRUDPortlet` - portlets to manage primary table
- `PurchasePortlet` - to perform and edit purchases (separate module `purchase`)
- `ZippedCsvUploadPortlet` - the portlet to upload archived *.csv* data located in `estore-csv-portlet`
- `BestEmployeePortlet` and `BestTVSellersPortlet` - are portlets used to display information about most productive employees or TV sellers
- `StatisticsPortlet` - the portlet to display two stats (sum of money recevied from purchases via the credit card and cost of archived TVs and smartphones)

**Service builder** and all services used are located inside `estore-service-build` module.

**Rest Api module**. Unfortunately it works weirdly. Says it has no serializer set,
though I did specified it, added jackson jars... But still does not want to serialize responses and reports about this error.
## Run locally

Clone the repository.

Navigate to the project root.

Check out `./config/local/portal-ext.properties` to adjust database connection properties.

In my case I used containerized Postgres, so to start it use

`docker run -d -e POSTGRES_PASSWORD=estore -e POSTGRES_USER=estore -p 5432:5432 postgres`

Assuming Blade CLI installed

`blade server init`

The command will take some time if you don't have a bundle already downloaded. 
It will download and install Liferay 7.3.5 GA6 bundle into the project directory.

Now portal is ready to be started.

`blade server start`

To stop portal

`blade server stop`

There is the `./import` folder where archive and `.csv` files located. Use and modify them if you want to import some data with an archive.



