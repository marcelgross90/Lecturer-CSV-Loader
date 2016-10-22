package models;

/**
 * Created by patrick_laptop on 21.10.16.
 */
import java.io.Serializable;

public abstract class AbstractModel implements Serializable
{
    protected long id;

    public AbstractModel( )
    {
    }

    public long getId( )
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }
}