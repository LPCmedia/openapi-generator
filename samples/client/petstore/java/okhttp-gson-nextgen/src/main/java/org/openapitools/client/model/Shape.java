/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.client.model.Quadrilateral;
import org.openapitools.client.model.Triangle;

import javax.ws.rs.core.GenericType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.openapitools.client.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Shape extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Shape.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!Shape.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'Shape' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<Quadrilateral> adapterQuadrilateral = gson.getDelegateAdapter(this, TypeToken.get(Quadrilateral.class));
            final TypeAdapter<Triangle> adapterTriangle = gson.getDelegateAdapter(this, TypeToken.get(Triangle.class));

            return (TypeAdapter<T>) new TypeAdapter<Shape>() {
                @Override
                public void write(JsonWriter out, Shape value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `Quadrilateral`
                    if (value.getActualInstance() instanceof Quadrilateral) {
                        JsonObject obj = adapterQuadrilateral.toJsonTree((Quadrilateral)value.getActualInstance()).getAsJsonObject();
                        elementAdapter.write(out, obj);
                        return;
                    }

                    // check if the actual instance is of the type `Triangle`
                    if (value.getActualInstance() instanceof Triangle) {
                        JsonObject obj = adapterTriangle.toJsonTree((Triangle)value.getActualInstance()).getAsJsonObject();
                        elementAdapter.write(out, obj);
                        return;
                    }

                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: Quadrilateral, Triangle");
                }

                @Override
                public Shape read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonObject jsonObject = elementAdapter.read(in).getAsJsonObject();

                    int match = 0;
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize Quadrilateral
                    try {
                        // validate the JSON object to see if any excpetion is thrown
                        Quadrilateral.validateJsonObject(jsonObject);
                        actualAdapter = adapterQuadrilateral;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'Quadrilateral'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        log.log(Level.FINER, "Input data does not match schema 'Quadrilateral'", e);
                    }

                    // deserialize Triangle
                    try {
                        // validate the JSON object to see if any excpetion is thrown
                        Triangle.validateJsonObject(jsonObject);
                        actualAdapter = adapterTriangle;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'Triangle'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        log.log(Level.FINER, "Input data does not match schema 'Triangle'", e);
                    }

                    if (match == 1) {
                        Shape ret = new Shape();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonObject));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for Shape: %d classes match result, expected 1. JSON: %s", match, jsonObject.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Shape() {
        super("oneOf", Boolean.FALSE);
    }

    public Shape(Quadrilateral o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Shape(Triangle o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Quadrilateral", new GenericType<Quadrilateral>() {
        });
        schemas.put("Triangle", new GenericType<Triangle>() {
        });
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Shape.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * Quadrilateral, Triangle
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof Quadrilateral) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof Triangle) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Quadrilateral, Triangle");
    }

    /**
     * Get the actual instance, which can be the following:
     * Quadrilateral, Triangle
     *
     * @return The actual instance (Quadrilateral, Triangle)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Quadrilateral`. If the actual instance is not `Quadrilateral`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Quadrilateral`
     * @throws ClassCastException if the instance is not `Quadrilateral`
     */
    public Quadrilateral getQuadrilateral() throws ClassCastException {
        return (Quadrilateral)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Triangle`. If the actual instance is not `Triangle`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Triangle`
     * @throws ClassCastException if the instance is not `Triangle`
     */
    public Triangle getTriangle() throws ClassCastException {
        return (Triangle)super.getActualInstance();
    }


 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Shape
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
    // validate oneOf schemas one by one
    int validCount = 0;
    // validate the json string with Quadrilateral
    try {
      Quadrilateral.validateJsonObject(jsonObj);
      validCount++;
    } catch (Exception e) {
      // continue to the next one
    }
    // validate the json string with Triangle
    try {
      Triangle.validateJsonObject(jsonObj);
      validCount++;
    } catch (Exception e) {
      // continue to the next one
    }
    if (validCount != 1) {
      throw new IOException(String.format("The JSON string is invalid for Shape with oneOf schemas: Quadrilateral, Triangle. %d class(es) match the result, expected 1. JSON: %s", validCount, jsonObj.toString()));
    }
  }
}

