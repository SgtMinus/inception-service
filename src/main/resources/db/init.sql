create table if not exists person_data
(
    id        bigserial primary key,
    name      varchar(255) not null,
    surname   varchar(255) not null,
    age       int          not null,
    city      varchar      not null,
    photoLink varchar
);

create table if not exists app_user
(
    id         bigserial primary key,
    email      varchar(255) not null,
    password   varchar(255) not null,
    personData bigint       not null,
    role       varchar(255) not null default 'USER'
);

create table if not exists dream_order
(
    id               bigserial primary key,
    externalId       uuid         not null,
    targetPersonInfo bigint       not null,
    customer         bigint       not null,
    finishDate       date         not null,
    orderStatus      varchar(255) not null default 'EXPECTATION',
    orderProcessing  bigint
);

create table if not exists dream
(
    id                       bigserial primary key,
    status                   varchar(255) not null,
    mainArchitect            bigint       not null,
    resultSuccessProbability float default 0
);

create table if not exists dream_strategy
(
    id          bigserial primary key,
    dream       bigint not null,
    createDate  date   not null,
    description text default 'Dream strategy'
);

create table if not exists dream_strategy_test
(
    id                                   bigserial not null,
    dreamStrategyChainSuccessProbability float              default 0,
    dreamStrategy                        bigint    not null,
    description                          text      not null default 'Dream strategy test',
    createDate                           date      not null
);

create table if not exists dream_stage
(
    id          bigserial primary key ,
    architectId bigint    not null,
    description text      not null default 'Dream stage',
    nextStage   bigint,
    stageNumber int       not null
);

create table if not exists dream_strategy_dream_stage
(
    dreamStrategyId bigint not null ,
    dreamStageId    bigint not null
);

create table if not exists dream_stage_participant
(
    id          bigserial primary key,
    personData  bigint       not null,
    stageRole   varchar(255) not null,
    isMustAlive boolean      not null
);

create table if not exists dream_stage_dream_stage_participant
(
    dreamStageId  bigint not null ,
    participantId bigint not null
);

alter table app_user
    add constraint fk_user_person_data foreign key (personData) references person_data (id) on delete cascade;

alter table dream_order
    add constraint fk_dream_order_target_person_info foreign key (targetPersonInfo) references person_data (id),
    add constraint fk_dream_order_customer foreign key (customer) references app_user (id);

alter table dream
    add constraint fk_dream_main_architect foreign key (mainArchitect) references app_user (id);

alter table dream_strategy
    add constraint fk_dream_strategy_dream foreign key (dream) references dream (id);

alter table dream_strategy_test
    add constraint fk_dream_strategy_test_dream_strategy foreign key (dreamStrategy) references dream_strategy (id);

alter table dream_strategy_dream_stage
    add constraint fk_dream_strategy_dream_stage_dream_strategy_id foreign key (dreamStrategyId) references dream_strategy (id),
    add constraint fk_dream_strategy_dream_stage_dream_stage_id foreign key (dreamStageId) references dream_stage (id);

alter table dream_stage
    add constraint fk_dream_stage_architect_id foreign key (architectId) references app_user (id),
    add constraint fk_dream_stage_next_stage foreign key (nextStage) references dream_stage (id);

alter table dream_stage_participant
    add constraint fk_dream_stage_participant_person_data foreign key (personData) references person_data (id);

alter table dream_stage_dream_stage_participant
    add constraint fk_dream_stage_dream_stage_participant_dream_stage_id foreign key (dreamStageId) references dream_stage (id),
    add constraint fk_dream_stage_dream_stage_participant_dream_participant_id foreign key (participantId) references dream_stage_participant (id);