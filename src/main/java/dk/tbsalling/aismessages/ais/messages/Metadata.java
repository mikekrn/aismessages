package dk.tbsalling.aismessages.ais.messages;

import java.io.Serializable;
import java.time.Instant;

@SuppressWarnings("serial")
public class Metadata implements Serializable {

    public Metadata(String source) {
        this.source = source;
        this.received = Instant.now();
    }

    public Metadata(String source, Instant received) {
        this.source = source;
        this.received = received;
    }

    @SuppressWarnings("unused")
	public String getSource() {
		return source;
	}

    public Instant getReceived() {
        return received;
    }

    @SuppressWarnings("unused")
	public String getCategory() {
		return category;
	}

    @SuppressWarnings("unused")
	public String getDecoderVersion() {
		return decoderVersion;
	}

    @Override
    public String toString() {
        return "Metadata{" +
                "source='" + source + '\'' +
                ", received=" + received +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metadata metadata = (Metadata) o;

        if (source != null ? !source.equals(metadata.source) : metadata.source != null) return false;
        return received != null ? received.equals(metadata.received) : metadata.received == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (received != null ? received.hashCode() : 0);
        return result;
    }

    // TODO Add decoder version from maven
	// TODO Add decode status and error descriptions
	private final static String decoderVersion = AISMessage.VERSION;
	private final static String category = "AIS";

	private final String source;
    private final Instant received;
}
