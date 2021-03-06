package com.tinkerpop.rexster.protocol.serializer.msgpack.templates.messages;

import com.tinkerpop.rexster.protocol.msg.ErrorResponseMessage;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bdeggleston
 * Date: 5/27/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorResponseMessageTemplate extends RexProMessageTemplate<ErrorResponseMessage> {

    protected int messageArraySize() {
        return super.messageArraySize() + 1;
    }

    protected ErrorResponseMessage instantiateMessage() {
        return new ErrorResponseMessage();
    }

    protected void writeMessageArray(final Packer pk, final ErrorResponseMessage msg) throws IOException {
        super.writeMessageArray(pk, msg);
        pk.write(msg.ErrorMessage);
    }

    protected ErrorResponseMessage readMessageArray(final Unpacker un, final ErrorResponseMessage msg) throws IOException {
        ErrorResponseMessage message = super.readMessageArray(un, msg);
        message.ErrorMessage = un.trySkipNil()?null:un.readString();
        return message;
    }
}
