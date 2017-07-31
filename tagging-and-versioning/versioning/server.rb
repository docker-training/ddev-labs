require 'sinatra'
require 'sinatra/namespace'  
require 'json'

set :bind, '0.0.0.0'
set :port, 3000

class Book  
    def initialize(title, author, isbn)  
        @title = title  
        @author = author  
        @isbn = isbn
    end 
    attr_accessor :title 
    attr_accessor :author 
    attr_accessor :isbn 
    def to_json
        {'title' => @title, 'author' => @author, 'isbn' => @isbn}.to_json
    end
end

get '/' do  
    'Welcome to BookList!'
end

namespace '/api/v1' do
    get '/books' do
        isbn = params[:isbn]
        book = Book.new('Foundation', 'Isaac Asimov', isbn)
        book.to_json
    end
end