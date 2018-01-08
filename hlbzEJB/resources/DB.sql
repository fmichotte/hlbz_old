-- ****************** SqlDBM: Microsoft SQL Server ******************
-- ******************************************************************

DROP TABLE [exception];
GO


DROP TABLE [groupe_admin];
GO


DROP TABLE [Alert];
GO


DROP TABLE [membre];
GO


DROP TABLE [Event];
GO


DROP TABLE [zair];
GO


DROP TABLE [Recurrence];
GO


DROP TABLE [Groupe];
GO


DROP TABLE [technical];
GO


DROP TABLE [Adresse];
GO



DROP SCHEMA [dbo];
GO


CREATE SCHEMA [dbo];
GO

--************************************** [technical]

CREATE TABLE [technical]
(
 [id]    NUMERIC(18,0) NOT NULL ,
 [key]   TEXT NOT NULL ,
 [value] TEXT NOT NULL ,

 CONSTRAINT [PK_technical] PRIMARY KEY CLUSTERED ([id] ASC)
);
GO



--************************************** [Adresse]

CREATE TABLE address
(
 ID     NUMERIC(18,0) NOT NULL ,
 rue    TEXT NOT NULL ,
 numero TEXT NOT NULL ,
 boite  TEXT NOT NULL ,
 zip    TEXT NOT NULL ,
 ville  TEXT NOT NULL ,
 pays   TEXT NOT NULL ,

 CONSTRAINT PK_Adresse PRIMARY KEY  (ID)
);



--************************************** [Groupe]

CREATE TABLE groupe
(
 ID        NUMERIC(18,0) NOT NULL ,
 nom       TEXT NOT NULL ,
 creation  DATE NOT NULL ,
 adresseID NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_Groupe PRIMARY KEY (ID)
);


--************************************** [zair]

CREATE TABLE zair
(
 ID        NUMERIC(18,0) NOT NULL ,
 eventDate timestamp  NOT NULL ,
 eventID   NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_zair PRIMARY KEY (ID)
);


--SKIP Index: [fkIdx_45]


--************************************** [Recurrence]

CREATE TABLE Recurrence
(
 ID           NUMERIC(18,0) NOT NULL ,
 type         INT NOT NULL ,
 frequence    INT NULL ,
 jour_semaine INT NULL ,
 jour         INT NULL ,
 mois         INT NULL ,
 ieme         INT NULL ,
 eventID      NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_Recurrence PRIMARY KEY (ID)
);



--************************************** [exception]

CREATE TABLE exception
(
 ID            NUMERIC(18,0) NOT NULL ,
 type          INT NOT NULL ,
 frequence     INT NULL ,
 jour_semaine  INT NULL ,
 jour          INT NULL ,
 mois          INT NULL ,
 ieme          INT NULL ,
 adresseID     NUMERIC(18,0) NULL ,
 recurrenceID  NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_exception PRIMARY KEY  (ID)
);


--************************************** [groupe_admin]

CREATE TABLE groupe_admin
(
 groupID  NUMERIC(18,0) NOT NULL ,
 membreID NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_groupe_admin PRIMARY KEY (groupID, membreID )
);

--************************************** [Alert]
CREATE TABLE Alert
(
 ID       NUMERIC(18,0) NOT NULL ,
 membreID NUMERIC(18,0) NOT NULL ,
 creation DATE NOT NULL ,
 type     INT NOT NULL ,
 actif    BIT NOT NULL ,

 CONSTRAINT PK_Alert PRIMARY KEY (ID)
);



--************************************** [membre]

CREATE TABLE membre
(
 ID        NUMERIC(18,0) NOT NULL ,
 titre     INT NULL ,
 nom       TEXT NOT NULL ,
 prenom    TEXT NULL ,
 email     TEXT NOT NULL ,
 telephone TEXT NULL ,
 portable  TEXT NULL ,
 creation  DATE NOT NULL ,
 admin     BIT NOT NULL ,
 etat      INT NOT NULL,
 adresseID NUMERIC(18,0) NOT NULL ,
 groupID   NUMERIC(18,0) NOT NULL ,
 zairID    NUMERIC(18,0) NOT NULL ,

 CONSTRAINT PK_membre PRIMARY KEY (ID)
);
--************************************** [Event]

CREATE TABLE [Event]
(
 [ID]            NUMERIC(18,0) NOT NULL ,
 [nom]           TEXT NULL ,
 [type]          INT NOT NULL ,
 [activite]      DATETIME NOT NULL ,
 [activite_fin]  DATETIME NULL ,
 [creation]      DATE NOT NULL ,
 [groupID]       NUMERIC(18,0) NOT NULL ,
 [adresseID]     NUMERIC(18,0) NOT NULL ,
 [responsableID] NUMERIC(18,0) NULL ,

 CONSTRAINT [PK_Event] PRIMARY KEY CLUSTERED ([ID] ASC),
 CONSTRAINT [fk_32] FOREIGN KEY ([groupID])
  REFERENCES [Groupe]([ID]),
 CONSTRAINT [fk_120] FOREIGN KEY ([adresseID])
  REFERENCES [Adresse]([ID]),
 CONSTRAINT [fk_141] FOREIGN KEY ([responsableID])
  REFERENCES [membre]([ID])
);
GO


--SKIP Index: [fkIdx_32]

--SKIP Index: [fkIdx_120]

--SKIP Index: [fkIdx_141]


