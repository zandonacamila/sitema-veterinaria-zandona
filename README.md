*** SISTEMA CLÍNICA VETERINÁRIA ZANDONÁ ***

## DESCRIÇÃO

*Protótipo de um sistema ERP de clínica veterinária.

## COMO RODAR

*Vá na pasta veterinaria-zandona-teste\target e execute o veterinaria-zandona-teste-0.0.1-SNAPSHOT através do comando 
*java -jar veterinaria-zandona-teste-0.0.1-SNAPSHOT.jar

## PORTA

*port:8080

## BANCO

-postgreSQL: *** spring.datasource.url=jdbc:postgresql://localhost:5432/veterinaria_zandona ***
-script no arquivo: clinica_veterinaria_zandona.sql ou clinica_backup.tar

## FUNCIONALIDADES

* "/" - Tela de início

* "/novoAnimal" - Tela de cadastro de um novo animal

* "/novaConsulta" - Tela de cadastro de uma consulta - agendada ou registro de consulta emergencial - a partir dessa tela, é determinado o valor da consulta

* "/agenda" - Tela com funcionalidade de deletar consultas agendadas

* "/telaDoMedico" - Tela com funcionalidade de encaminhar para a tela de alterar consultas agendadas, para o médico acrescentar tratamento, diagnóstico, medicação e, 
*ocasionalmente, alterar o nome e dados relativos ao animal

* "/alteraConsulta" - Tela com acesso a partir da "/telaDoMedico", que altera a consulta e salva as alterações no banco de dados

* "/historicoDeConsultasFinalizadas" - Nessa tela, só aparecem as consultas já finalizadas pelo médico, com diagnóstico e valor, além de informações do animal

* "/detalhesConsulta?{id}" - Essa tela é acessada a partir de "/historicoDeConsultasFinalizadas" e permite acessar a consulta, individualmente

## BUGS/MELHORIAS

- não há required nos campos <select> |

- não foi possível gravar o medicamento receitado nem suas informações(código, nome, descrição) |

- a especialidade ficou travada em um valor por falta de tempo |

- não é feita validação no banco para consultar se o animal já é registrado na clínica | 

- não existe agenda com a disponibilidade dos médicos | 

- os médicos não estão ligados à especialidade, nem à espécie - fica a cargo de quem registra a consulta, registrar médico e especialidade | 

- o veterinário responsável não é informado na tela "/detalhesConsulta?{id}" | 

- não foi feito tratamento de erros ou comentários nos métodos, por falta de tempo | 

- a raça não é considerada para agendar consultas, cadastrar animais ou selecionar médicos | 

- a duração, a descrição e o medicamento não ficam registrados em tratamento 










