create index IX_377B4F6C on chg_Area (areaId);
create index IX_F19FAF2F on chg_Area (name);
create index IX_8AE89BAA on chg_Area (userId);

create index IX_AB95EB65 on chg_Contact (areaId);
create index IX_CC60DE42 on chg_Contact (contactId);
create index IX_B5B451A7 on chg_Contact (createDate);
create index IX_D8A77AC3 on chg_Contact (email);
create index IX_5D841E4F on chg_Contact (status);
create index IX_DDCEF713 on chg_Contact (subject);

create index IX_54D1B587 on chg_Tracing (areaId);
create index IX_B12848E0 on chg_Tracing (contactId);