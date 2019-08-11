# Zup Barber Shop
Este projeto foi criado por alunos do Projeto [Estrelas fora da caixa](https://www.zup.com.br/estrelas-fora-da-caixa) da empresa [Zup](https://www.zup.com.br/), O Estrelas fora da caixa vem para incluir jovem na área de desenvolvimento, dando oportunidade  para esse jovem. 
Em 5 meses foram administradas por uma equipe da [MasterTech](https://mastertech.com.br/) aulas de java backend.

**O Zup Barber Shop** é uma API Rest para gerenciamento e agendamento de horários por serviços de uma barbearia.
Para o gerente da barbearia proporciona criar horários por mês para serviços disponíveis, e manutenção de todos os horários e agendamentos.
Para os clientes da a possibilidade de visualizar todos os horários disponíveis de todos os serviços, e com uma rápido cadastro deste cliente o mesmo poderá se agendar no serviço e horário desejado, sem sair de casa e sem perder tempo esperando sua vez.

## Endpoints

#Get#

**_(/api/zup/barber/shop/todos/barba)_**
Retorna todos os horarios para o serviço de fazer barba.

**_(/api/zup/barber/shop/todos/cabelo)_**
Retorna todos os horarios para o serviço de fazer cabelo.

**_(/api/zup/barber/shop/todos/pezinho)_**
Retorna todos os horarios para o serviço de fazer pezinho.

**_(/api/zup/barber/shop/todos/sobrancelha)_**
Retorna todos os horarios para o serviço de fazer sobrancelha.

**_(/api/zup/barber/shop/horarios/barba/disponiveis?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios disponiveis para o serviço de fazer barba.

**_(/api/zup/barber/shop/horarios/cabelo/disponiveis?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios disponiveis para o serviço de fazer cabelo.

**_(/api/zup/barber/shop/horarios/pezinho/disponiveis?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios disponiveis para o serviço de fazer pezinho.

**_(/api/zup/barber/shop/horarios/sobrancelha/disponiveis?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios disponiveis para o serviço de fazer sobrancelha.

**_(/api/zup/barber/shop/horarios/barba/agendados?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios agendados para o serviço de fazer barba.

**_(/api/zup/barber/shop/horarios/cabelo/agendados?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios agendados para o serviço de fazer cabelo.

**_(/api/zup/barber/shop/horarios/pezinho/agendados?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios agendados para o serviço de fazer pezinho.

**_(/api/zup/barber/shop/horarios/sobrancelha/agendados?dia=dia&mes=mes)_**
Passando na url o dia= dia requerido e mes= mes requerido
Retorna todos os horarios agendados para o serviço de fazer sobrancelha.

#Post#

**_(/api/zup/barber/shop/criar/mes/{diasMes})_**
Passando na url {diasMes} a quandidade de dias coresppondente ao mes que deseja criar.
Passando no body em formato de Json o nome do mes.
Exemplo:
   {
        "mes": "nome do mes"
 
    }

Desta forma é criado todos os ararios para todos os dias e serviços do mes.

#Put#

**_(/api/zup/barber/shop/agendar/barba/{idHorario})_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario ou o id do usuario.
Exemplo:
{
	"usuario": {
		"id": 1
	}
}

Para incluir o usuario no horario que foi escolhido, gerando assim o agendamanto do mesmo.

**_(/api/zup/barber/shop/agendar/cabelo/{idHorario})_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario ou o id do usuario.
Exemplo:
{
	"usuario": {
		"id": 1
	}
}

Para incluir o usuario no horario que foi escolhido, gerando assim o agendamanto do mesmo.

**_(/api/zup/barber/shop/agendar/pezinho/{idHorario})_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario ou o id do usuario.
Exemplo:
{
	"usuario": {
		"id": 1
	}
}

Para incluir o usuario no horario que foi escolhido, gerando assim o agendamanto do mesmo.

**_(/api/zup/barber/shop/agendar/sobrancelha/{idHorario})_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario ou o id do usuario.
Exemplo:
{
	"usuario": {
		"id": 1
	}
}

Para incluir o usuario no horario que foi escolhido, gerando assim o agendamanto do mesmo.

**_(/api/zup/barber/shop/atualizar/horario/barba/{id}")_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario null.
Exemplo:
{
	"usuario": null
}

Para disponibilizar um horario antes agendado, em caso de desistencia por parte do cliente.

**_(/api/zup/barber/shop/atualizar/horario/cabelo/{id}")_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario null.
Exemplo:
{
	"usuario": null
}

Para disponibilizar um horario antes agendado, em caso de desistencia por parte do cliente.

**_(/api/zup/barber/shop/atualizar/horario/pezinho/{id}")_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario null.
Exemplo:
{
	"usuario": null
}

Para disponibilizar um horario antes agendado, em caso de desistencia por parte do cliente.

**_(/api/zup/barber/shop/atualizar/horario/sobrancelha/{id}")_**
Passando na url {idHorario} o id do horario .
Passando no body em formato de Json o usuario null.
Exemplo:
{
	"usuario": null
}

Para disponibilizar um horario antes agendado, em caso de desistencia por parte do cliente.

#Delete#

**_(/api/zup/barber/shop/excluir/horario/barba/{id}")_**
Passando na url {idHorario} o id do horario .
Para excluir um horario especifico por serviço.

**_(/api/zup/barber/shop/excluir/horario/cabelo/{id}")_**
Passando na url {idHorario} o id do horario .
Para excluir um horario especifico por serviço.

**_(/api/zup/barber/shop/excluir/horario/pezinho/{id}")_**
Passando na url {idHorario} o id do horario .
Para excluir um horario especifico por serviço.

**_(/api/zup/barber/shop/excluir/horario/sobrancelha/{id}")_**
Passando na url {idHorario} o id do horario .
Para excluir um horario especifico por serviço.