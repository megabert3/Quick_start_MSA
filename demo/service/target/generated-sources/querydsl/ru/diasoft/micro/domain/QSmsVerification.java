package ru.diasoft.micro.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSmsVerification is a Querydsl query type for SmsVerification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSmsVerification extends EntityPathBase<SmsVerification> {

    private static final long serialVersionUID = -1470469561L;

    public static final QSmsVerification smsVerification = new QSmsVerification("smsVerification");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath processGUID = createString("processGUID");

    public final StringPath secretCode = createString("secretCode");

    public final StringPath status = createString("status");

    public QSmsVerification(String variable) {
        super(SmsVerification.class, forVariable(variable));
    }

    public QSmsVerification(Path<? extends SmsVerification> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSmsVerification(PathMetadata metadata) {
        super(SmsVerification.class, metadata);
    }

}

