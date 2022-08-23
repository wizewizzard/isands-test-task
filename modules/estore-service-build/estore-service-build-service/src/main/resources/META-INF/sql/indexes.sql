create index IX_58268D6A on ESTORE_Device (groupId, deviceTypeId);
create index IX_A30C190A on ESTORE_Device (groupId, name[$COLUMN_LENGTH:150$]);
create index IX_D8C80633 on ESTORE_Device (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_84F27D75 on ESTORE_Device (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3A034970 on ESTORE_DeviceType (groupId, name[$COLUMN_LENGTH:100$]);
create index IX_E071340D on ESTORE_DeviceType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CCE159CF on ESTORE_DeviceType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4BDC440B on ESTORE_Employee (groupId, positionId);
create index IX_671715CB on ESTORE_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7A70930D on ESTORE_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FC2B160A on ESTORE_EmployeeDeviceCons (companyId);
create index IX_CE2F62FB on ESTORE_EmployeeDeviceCons (employeeId);

create index IX_12F58F49 on ESTORE_EmployeePosition (groupId, name[$COLUMN_LENGTH:100$]);
create index IX_29FF7394 on ESTORE_EmployeePosition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1237CF16 on ESTORE_EmployeePosition (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FFCDF785 on ESTORE_Purchase (groupId, deviceId);
create index IX_671AFE2 on ESTORE_Purchase (groupId, employeeId, deviceId);
create index IX_6B39CC9E on ESTORE_Purchase (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DB68E2A0 on ESTORE_Purchase (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F5CA5065 on ESTORE_PurchaseType (groupId, name[$COLUMN_LENGTH:100$]);
create index IX_BE73CCF8 on ESTORE_PurchaseType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_89FB317A on ESTORE_PurchaseType (uuid_[$COLUMN_LENGTH:75$], groupId);