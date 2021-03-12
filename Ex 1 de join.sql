INSERT INTO  tb_classe (classe_p,main_weapon)VALUES 
('Guerreiro','Machado'),('Mago','Livro'),('Arqueiro','Arco'),('Duelista','Espada'),('Curandeiro','Cetro');

INSERT INTO  tb_personagem (attack,defense,cla_p,fk_id_classe)VALUES 
(3000,2100,'Os Brabos',2),(3100,2123,'Os Brabos',3),(2500,2120,'Os Brabos',1),(1500,2500,'Os Manés',1),
(3500,2200,'Os Manés',2),(3600,3000,'Os Brabos',4),(3250,2500,'Os Alquimista',5),(3900,1900,'Os Alquimistas',1);

select * from tb_classe;
select * from tb_personagem;

select* from  tb_personagem where attack >2000;
select * from  tb_personagem where defense >1000 or defense <2000;
select * from   tb_classe where classe_p like '%c%';

SELECT tb_personagem.id_personagem, tb_personagem.attack,tb_personagem.defense,tb_personagem.cla_p, tb_personagem.fk_id_classe 
FROM tb_personagem
INNER JOIN tb_classe on  tb_classe.id_classe = tb_personagem.fk_id_classe;
